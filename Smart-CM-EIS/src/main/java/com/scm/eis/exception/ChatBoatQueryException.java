package com.scm.eis.exception;

public class ChatBoatQueryException extends Exception {
    private final static String Chat_Boat_Query_Exception="Your have one already query status";

    public ChatBoatQueryException() {

        super(getChatBoatQueryException());
    }

    public static String getChatBoatQueryException(){

        return Chat_Boat_Query_Exception;
    }

}
