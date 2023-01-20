package com.employee.demo.Exception;

public class NoSuchEmployeeExistsException extends RuntimeException{
    private String message;
    public NoSuchEmployeeExistsException(){}
    public NoSuchEmployeeExistsException(String msg){
        super(msg);
        this.message=msg;

    }
}
