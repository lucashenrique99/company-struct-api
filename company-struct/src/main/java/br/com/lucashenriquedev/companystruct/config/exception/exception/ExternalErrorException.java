package br.com.lucashenriquedev.companystruct.config.exception.exception;

public class ExternalErrorException extends RuntimeException{
    public ExternalErrorException(String message) {
        super(message);
    }
}
