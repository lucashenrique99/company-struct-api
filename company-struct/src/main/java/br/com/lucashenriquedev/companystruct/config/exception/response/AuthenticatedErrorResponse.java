package br.com.lucashenriquedev.companystruct.config.exception.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticatedErrorResponse implements ErrorResponse {

    private String error;
    private String description;
    private WebRequestInfoDTO request;
    private String code;

    public AuthenticatedErrorResponse(String error) {
        this.error = error;
    }

}
