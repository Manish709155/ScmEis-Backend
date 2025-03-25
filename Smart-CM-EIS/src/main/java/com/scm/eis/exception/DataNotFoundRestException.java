package com.scm.eis.exception;


import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class DataNotFoundRestException extends RestExecption{
    public final String errorCode = RestExceptionCode.DATA_NOT_FOUND_ERROR_CODE;
    private String message = "Data Not Found. ";

    public DataNotFoundRestException(String message) {
        this.message += message;
    }

}
