package com.scm.eis.exception;

public class UserServiceRegistrationCreateException extends Exception {
    private final static String USER_SERVICE_REGISTRATION_CREATE_EXCEPTION="This pan number and adhar number is already exist. Please try to login with existing credentials.";

    public UserServiceRegistrationCreateException() {

        super(getUserServiceRegistrationCreateException());
    }

    public static String getUserServiceRegistrationCreateException(){

        return USER_SERVICE_REGISTRATION_CREATE_EXCEPTION;
    }

}


