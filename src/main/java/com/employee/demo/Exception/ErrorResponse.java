package com.employee.demo.Exception;

public class ErrorResponse {
    private int statusCode;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public ErrorResponse() {
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponse(int value, String message)
    {
        super();
        this.message = message;
    }
}
