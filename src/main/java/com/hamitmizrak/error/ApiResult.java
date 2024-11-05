package com.hamitmizrak.error;

import lombok.*;
import java.util.Date;
import java.util.Map;

// LOMBOK
@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
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

    // PSVM
    /*
    public static void main(String[] args) {
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(200);
        System.out.println(apiResult.getStatus());

        ApiResult apiResult1 = ApiResult.builder()
                .status(300)
                .build();
        System.out.println(apiResult1);
        System.out.println(apiResult1.getStatus());
    }
    */

} //end ApiResult
