package org.example.exception;

public class SocialException extends RuntimeException {

    private Errors errors;
    public SocialException(Errors errors) {
        this.errors = errors;
    }
    public Errors getErrors() {
        return errors;
    }

}
