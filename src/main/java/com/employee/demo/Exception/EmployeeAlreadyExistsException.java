package com.employee.demo.Exception;

public class EmployeeAlreadyExistsException extends RuntimeException{
    public String message;
   public EmployeeAlreadyExistsException(){}
    public EmployeeAlreadyExistsException(String msg){
        super(msg);
        this.message=msg;

    }

}
