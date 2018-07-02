package com.art2cat.dev.composite;

/**
 * com.art2cat.dev.composite
 *
 * @author art2c
 * @date 5/30/2018
 */
public class FileTreatmentException extends Exception {
    
    /**
     * Constructs a new exception with {@code null} as its detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to {@link #initCause}.
     */
    public FileTreatmentException() {
    }
    
    /**
     * Constructs a new exception with the specified detail message.  The cause is not initialized, and may subsequently
     * be initialized by a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()}
     * method.
     */
    public FileTreatmentException(String message) {
        super(message);
    }
}
