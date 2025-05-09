package com.scm.eis.exception;

import com.scm.eis.constant.SolutionStatus;

public class ChatBoatQueryException extends Exception {
    private final static String Chat_Boat_Query_Exception="Your previous registered query has been already in";

    public ChatBoatQueryException(SolutionStatus solutionStatus) {

        super(getChatBoatQueryException()+" "+solutionStatus+" "+"State.");
    }

    public static String getChatBoatQueryException(){

        return Chat_Boat_Query_Exception;
    }

}
