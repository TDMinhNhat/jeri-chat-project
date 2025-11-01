package io.github.tdminhnhat.exception;

public class MinIOException extends RuntimeException {
    public MinIOException() {
        super();
    }

    public MinIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public MinIOException(Throwable cause) {
        super(cause);
    }

    protected MinIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MinIOException(String message) {
        super(message);
    }
}
