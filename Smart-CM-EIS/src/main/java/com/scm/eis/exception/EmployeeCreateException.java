package com.scm.eis.exception;

public class EmployeeCreateException extends Exception{

    private final static String EMPLOYEE_CREATE_EXCEPTION="This pan number and adhar number is already exist. Please try to login with existing credentials.";
    public  EmployeeCreateException(){

        super(getEmployeeCreateException());

    }
    public static String getEmployeeCreateException(){

        return EMPLOYEE_CREATE_EXCEPTION;
    }
}
