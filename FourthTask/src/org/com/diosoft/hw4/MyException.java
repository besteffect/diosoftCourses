package org.com.diosoft.hw4;

/**
 * Created by vsv on 10/6/2015.
 */
public class MyException extends Exception{
    private final String errorCode;
    public MyException(String errorCode){
        this.errorCode=errorCode;
    }
    public String getErrorCode(){
        return errorCode;
    }
}
