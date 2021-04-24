package br.com.lucashenriquedev.companystruct.config.exception.controller;

import br.com.lucashenriquedev.companystruct.config.exception.exception.ExternalErrorException;
import br.com.lucashenriquedev.companystruct.config.exception.exception.ResourceNotFoundException;
import br.com.lucashenriquedev.companystruct.config.exception.response.AuthenticatedErrorResponse;
import br.com.lucashenriquedev.companystruct.config.exception.response.ErrorResponseWrapper;
import br.com.lucashenriquedev.companystruct.config.exception.response.PublicErrorResponse;
import br.com.lucashenriquedev.companystruct.config.exception.response.WebRequestInfoDTO;
import br.com.lucashenriquedev.companystruct.modules.users.service.AuthUtilsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ErrorHandlingController extends ResponseEntityExceptionHandler {

    @Autowired
    private AuthUtilsService utilsService;

    @Autowired
    private ObjectMapper mapper;

    @ExceptionHandler({IllegalArgumentException.class, ExternalErrorException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) throws IOException {
        ErrorResponseWrapper response = new ErrorResponseWrapper(ex.getMessage());
        handleErrorLog(response, ex);

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(getResponseBody(response));
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex) throws IOException {
        ErrorResponseWrapper response = new ErrorResponseWrapper(ex.getMessage());
        handleErrorLog(response, ex);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(getResponseBody(response));
    }

    @ExceptionHandler({DateTimeParseException.class})
    public ResponseEntity<Object> handleDateTimeParseException(DateTimeParseException ex, WebRequest request) throws IOException {
        ErrorResponseWrapper response = new ErrorResponseWrapper(
                AuthenticatedErrorResponse.builder()
                        .error("Invalid date/time format")
                        .request(new WebRequestInfoDTO(request))
                        .description(String.format("%s: %s", ex.getClass().getName(), ex.getLocalizedMessage()))
                        .build());

        handleErrorLog(response, ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(getResponseBody(response));
    }

    @ExceptionHandler({DataAccessException.class})
    public ResponseEntity<Object> handleSqlException(DataAccessException ex, WebRequest request) throws IOException {
        var builder = AuthenticatedErrorResponse.builder()
                .request(new WebRequestInfoDTO(request))
                .description(String.format("%s: %s", ex.getClass().getName(), ex.getLocalizedMessage()));

        if (ex.getMostSpecificCause() instanceof SQLException) {
            SQLException sqlException = (SQLException) ex.getMostSpecificCause();

            builder.code(sqlException.getSQLState())
                    .error(String.join(". ",
                            "An error occurred while a transaction was being saved",
                            sqlException.getSQLState(),
                            "Code " + sqlException.getErrorCode()));
        }

        ErrorResponseWrapper response = new ErrorResponseWrapper(builder.build());
        handleErrorLog(getResponseBody(response), ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(getResponseBody(response));
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) throws IOException {
        ErrorResponseWrapper response = new ErrorResponseWrapper(
                AuthenticatedErrorResponse.builder()
                        .error("Insufficient permissions")
                        .request(new WebRequestInfoDTO(request))
                        .description(String.format("%s: %s", ex.getClass().getName(), ex.getLocalizedMessage()))
                        .build());
        handleErrorLog(response, ex);

        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(getResponseBody(response));
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) throws IOException {
        ErrorResponseWrapper response = new ErrorResponseWrapper(
                AuthenticatedErrorResponse.builder()
                        .error("Internal server error")
                        .request(new WebRequestInfoDTO(request))
                        .description(String.format("%s: %s", ex.getClass().getName(), ex.getLocalizedMessage()))
                        .build());
        handleErrorLog(response, ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getResponseBody(response));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }

    private void handleErrorLog(ErrorResponseWrapper response, Exception e) throws JsonProcessingException {
        final String errors = mapper.writeValueAsString(response);
        final String currentUser = utilsService.getCurrentUsername().orElse("Unknown User");
        final String message = "[" + currentUser + "]: " + errors;
        log.error(message, e);
    }

    private ErrorResponseWrapper getResponseBody(ErrorResponseWrapper response) {
        if (utilsService.isAuthenticated()) {
            return response;
        }

        return new ErrorResponseWrapper(response.getErrors().
                stream()
                .map(e -> new PublicErrorResponse(e.getError()))
                .collect(Collectors.toList()));
    }
}
