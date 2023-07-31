package com.example.RESTFULL.RESTControllers;

public class StudentNotFoundExecption extends RuntimeException{

    public StudentNotFoundExecption(String message) {
        super(message);
    }

    public StudentNotFoundExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundExecption(Throwable cause) {
        super(cause);
    }
}
