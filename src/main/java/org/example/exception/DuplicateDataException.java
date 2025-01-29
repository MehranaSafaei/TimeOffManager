package org.example.exception;

public class DuplicateDataException extends Exception {

    public DuplicateDataException() {
        super("Duplicate data found");
    }
}
