package br.com.lucashenriquedev.companystruct.config.exception.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class DefaultErrorException extends Exception {

    @JsonIgnore
    private HttpStatus status;

    public DefaultErrorException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
