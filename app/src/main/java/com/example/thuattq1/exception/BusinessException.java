package com.example.thuattq1.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thuattq1 on 2/10/2017.
 */

public class BusinessException extends Exception implements Serializable {
    private List<String> errorCodes;

    public BusinessException() {
        errorCodes = new ArrayList<String>();
    }

    /*public BusinessException(String message) {
        super(message);
    }*/

    public BusinessException(Throwable cause) {
        super(cause);
    }

    /*public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }*/

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }
}
