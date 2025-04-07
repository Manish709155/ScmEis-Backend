package com.scm.eis.exception;

public class UserCreateException extends  Exception {
private final static String USER_CREATE_EXCEPTION="This pan number and adhar number is already exist. Please try to login with existing credentials.";
    public  UserCreateException(){

        super(getUserCreateException());

    }
    public static String getUserCreateException(){

        return USER_CREATE_EXCEPTION;
    }
}
