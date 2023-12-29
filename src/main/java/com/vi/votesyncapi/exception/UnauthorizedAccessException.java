package com.vi.votesyncapi.exception;

public class UnauthorizedAccessException extends RuntimeException{
    public UnauthorizedAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
