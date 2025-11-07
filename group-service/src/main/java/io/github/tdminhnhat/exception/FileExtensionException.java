package io.github.tdminhnhat.exception;

public class FileExtensionException extends RuntimeException {
    public FileExtensionException() {
        super();
    }

    public FileExtensionException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileExtensionException(Throwable cause) {
        super(cause);
    }

    protected FileExtensionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public FileExtensionException(String message) {
        super(message);
    }
}
