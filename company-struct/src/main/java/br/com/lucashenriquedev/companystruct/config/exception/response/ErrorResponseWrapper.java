package br.com.lucashenriquedev.companystruct.config.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseWrapper {

    private List<ErrorResponse> errors;

    public ErrorResponseWrapper(String error) {
        this.errors = Collections.singletonList(new AuthenticatedErrorResponse(error));
    }

    public ErrorResponseWrapper(ErrorResponse error) {
        this.errors = Collections.singletonList(error);
    }

}
