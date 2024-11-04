package com.hamitmizrak.error;

import java.util.Date;
import java.util.Map;

public class ApiResult {

    // sem pvc
    // Field
    private int status;
    private String error;
    private String message;

    private String path;
    private Map<String,String> validationErrors;
    private Date createDate;

    // Parametresiz Constructor
    public  ApiResult(){}

    // sem
    public ApiResult(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    // sem p
    public ApiResult(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // GETTER AND SETTER

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
} //end ApiResult
