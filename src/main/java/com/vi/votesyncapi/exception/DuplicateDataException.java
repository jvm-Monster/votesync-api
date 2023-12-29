package com.vi.votesyncapi.exception;

public class DuplicateDataException extends RuntimeException{
    public DuplicateDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateDataException(String message) {
        super(message);
    }
}
