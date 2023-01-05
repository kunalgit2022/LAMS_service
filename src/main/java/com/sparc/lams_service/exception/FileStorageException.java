package com.sparc.lams_service.exception;

public class FileStorageException extends RuntimeException{
	private static final long serialVersionUID = 1 ;

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
