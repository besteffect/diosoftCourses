package org.com.diosoft.hw4;

/**
 * Created by vsv on 10/6/2015.
 */
public class MyException extends RuntimeException{
    private final String errorMessage;

    public MyException(String errorCode){
        this.errorMessage=errorCode;
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
