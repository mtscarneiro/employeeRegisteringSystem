package com.mtscarneiro.cconecte.exception;

public class ContentNotExistentException extends RuntimeException {
    public ContentNotExistentException() {
        super("Content not exists in database! ");
    }
}
