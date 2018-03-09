package com.codejamlocalcopy.localjam.storage.exception;

/**
 * Local jam Storage Exception
 */
public class LocalJamStorageRuntimeException extends RuntimeException {
    /**
     * Exception created from message.
     *
     * @param msg The string message to include.
     */
    public LocalJamStorageRuntimeException(String msg) {
        super(msg);
    }

    /**
     * Exception created from message and cause.
     *
     * @param msg The string message to include.
     * @param cause The cause of this exception.
     */
    public LocalJamStorageRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Exception created from cause.
     *
     * @param cause The cause of this exception.
     */
    public LocalJamStorageRuntimeException(Throwable cause) {
        super(cause);
    }
}
