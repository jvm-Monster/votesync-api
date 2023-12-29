package com.vi.votesyncapi.exception;

    public class DatabaseConnectionException extends RuntimeException {

        public DatabaseConnectionException(String message, Throwable cause) {
            super(message, cause);
        }

        public DatabaseConnectionException(String message) {
            super(message);
        }
    }

