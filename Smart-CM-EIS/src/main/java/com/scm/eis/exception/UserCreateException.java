package com.scm.eis.exception;

public class UserCreateException extends  Exception {
private final static String USER_CREATE_EXCEPTION="This mobile number and email ID are already in use. Please try a different one.";
    public  UserCreateException(){

        super(getUserCreateException());

    }
    public static String getUserCreateException(){

        return USER_CREATE_EXCEPTION;
    }
}
