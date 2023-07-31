package com.example.RESTFULL.RESTControllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestEceptionhandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrResponse> handleException (Exception  err){

        StudentErrResponse error = new StudentErrResponse();

        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(err.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<> (error, HttpStatus.BAD_REQUEST);
    }
}
