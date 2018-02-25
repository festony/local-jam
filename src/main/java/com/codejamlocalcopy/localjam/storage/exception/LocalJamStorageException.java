package com.codejamlocalcopy.localjam.storage.exception;

/**
 * Local jam Storage Exception
 */
public class LocalJamStorageException extends Exception {
    /**
     * Exception created from message.
     *
     * @param msg The string message to include.
     */
    public LocalJamStorageException(String msg) {
        super(msg);
    }

    /**
     * Exception created from message and cause.
     *
     * @param msg The string message to include.
     * @param cause The cause of this exception.
     */
    public LocalJamStorageException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Exception created from cause.
     *
     * @param cause The cause of this exception.
     */
    public LocalJamStorageException(Throwable cause) {
        super(cause);
    }
}
