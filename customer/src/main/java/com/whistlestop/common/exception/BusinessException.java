package com.whistlestop.common.exception;

/*
 Custom exception used for expected business errors.

 Allows the backend to return a clear status code and message
 when the request is invalid or breaks a business rule.
*/
public class BusinessException extends RuntimeException {
    private final int statusCode;

    /*
     Creates a business exception with an HTTP status code.
    */
    public BusinessException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    /*
     Returns the HTTP status code that should be sent back.
    */
    public int getStatusCode() {
        return statusCode;
    }
}
