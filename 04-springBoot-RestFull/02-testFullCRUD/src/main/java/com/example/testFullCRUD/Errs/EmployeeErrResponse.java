package com.example.testFullCRUD.Errs;

public class EmployeeErrResponse {
    private int statusCode;

    private String message;

    private Long timeStamp;

    public EmployeeErrResponse(){}
    public EmployeeErrResponse(int statusCode, String message, Long timeStamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
