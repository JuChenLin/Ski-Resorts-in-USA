package com.priscilla.web.exception;

public class DataNotExistException extends RuntimeException{

    public DataNotExistException() {}

    public DataNotExistException(String message) {
        super(message);
    }
}
