package io.github.tdminhnhat.exception;

public class QueryNotFoundException extends RuntimeException {
    public QueryNotFoundException() {
        super();
    }

    public QueryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public QueryNotFoundException(Throwable cause) {
        super(cause);
    }

    protected QueryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public QueryNotFoundException(String message) {
        super(message);
    }
}
