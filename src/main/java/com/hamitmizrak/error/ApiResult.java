package com.hamitmizrak.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import java.util.Date;
import java.util.Map;

// LOMBOK
@Data
@Builder
@AllArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL) // Backentten Frontend'e null olan verileri gönderme
public class ApiResult {

    // sem pvc
    private String path;
    private String message;
    private String error;
    private Integer status;
    private Date createdDate=new Date(System.currentTimeMillis());
    private Map<String,String> validationErrors;

    // parametresiz constructor
    public ApiResult() {
    }

    // parametreli constructor pms
    public ApiResult(String path, String message, Integer status) {
        this.path = path;
        this.message = message;
        this.status = status;
    }

    // parametreli constructor pmes
    public ApiResult(String path, String message, String error, Integer status) {
        this.path = path;
        this.message = message;
        this.error = error;
        this.status = status;
    }
} //end class