package se.cromigon.beepsend.api.exceptions;

public class ApiTokenInvalidException extends RuntimeException {

    public ApiTokenInvalidException() { super(); }

    public ApiTokenInvalidException(String message) { super(message); }

    public ApiTokenInvalidException(String message, Throwable cause) { super(message, cause); }

    public ApiTokenInvalidException(Throwable cause) { super(cause); }
}
