package se.cromigon.beepsend.api.exceptions;

public class ApiTokenNotSetException extends RuntimeException {

    public ApiTokenNotSetException() { super(); }

    public ApiTokenNotSetException(String message) { super(message); }

    public ApiTokenNotSetException(String message, Throwable cause) { super(message, cause); }

    public ApiTokenNotSetException(Throwable cause) { super(cause); }
}
