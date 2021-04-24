package br.com.lucashenriquedev.companystruct.config.exception.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicErrorResponse implements ErrorResponse {

    private String error;

}
