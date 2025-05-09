package com.scm.eis.exception;

import com.scm.eis.constant.SolutionStatus;

public class QueryCreatedException extends Exception {
  private final static String QUERY_CREATED_EXCEPTION="Your previous registered query has been already in";

  public QueryCreatedException(SolutionStatus solutionStatus) {

    super(getQueryCreatedException()+" "+solutionStatus+" "+"State.");
  }

  public static String getQueryCreatedException(){

    return QUERY_CREATED_EXCEPTION;
  }
}
