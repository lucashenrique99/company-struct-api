package br.com.lucashenriquedev.companystruct.config.exception.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
