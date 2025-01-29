package org.example.exception;

public enum Errors {

    DUPLICATE_DATA_EXCEPTION("A record with the same data already exists."),
    SAVE_RECORD_EXCEPTION("An error occurred while saving the record.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}


