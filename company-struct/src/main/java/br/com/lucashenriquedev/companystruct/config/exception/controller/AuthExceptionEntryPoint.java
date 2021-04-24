package br.com.lucashenriquedev.companystruct.config.exception.controller;

import br.com.lucashenriquedev.companystruct.config.exception.response.SimpleErrorResponse;
import br.com.lucashenriquedev.companystruct.config.exception.response.WebRequestInfoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Slf4j
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException arg2) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), new SimpleErrorResponse("Unauthorized access"));

        Map<String, Object> errors = new HashMap<>();
        errors.put("error", "Unauthorized access");
        errors.put("description", arg2.getLocalizedMessage());
        errors.put("request", new WebRequestInfoDTO(request));


        log.error("{}", mapper.writeValueAsString(errors), arg2);
    }
}