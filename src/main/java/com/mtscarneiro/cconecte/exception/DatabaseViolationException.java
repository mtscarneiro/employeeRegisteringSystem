package com.mtscarneiro.cconecte.exception;

public class DatabaseViolationException extends RuntimeException {

    public DatabaseViolationException(String message) {
        super(message);
    }
}
