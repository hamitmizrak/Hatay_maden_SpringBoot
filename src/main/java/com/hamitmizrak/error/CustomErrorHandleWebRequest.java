package com.hamitmizrak.error;

import com.hamitmizrak.utily.FrontEnd;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LOMBOK
@Log4j2 // Loglama
@RequiredArgsConstructor //Injection (Autowired)

// ErrorController
// ErrorAttributes
// WebRequest
// http://localhost:4444/error

@RestController
@CrossOrigin(origins = {FrontEnd.REACT_URL, FrontEnd.ANGULAR_URL})
public class CustomErrorHandleWebRequest implements ErrorController {

    // INJECTION
    private final ErrorAttributes errorAttributes;

    // FIELD
    private ApiResult apiResult;
    private String path;
    private String message;
    private Integer status;
    private Map<String, String> validationErrors;

    // http://localhost:4444/error
    // Spring Frameworkten gelen hataları kendimize göre hataları alıp ApiResultta ekledik
    public ApiResult handleErrorMethod(WebRequest webRequest) {
        // Spring >=2.3
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(
                webRequest, ErrorAttributeOptions.of(
                        ErrorAttributeOptions.Include.MESSAGE,
                        ErrorAttributeOptions.Include.BINDING_ERRORS
                )
        ); //end attributes

        // Spring'ten verileri almak
        status= (Integer) attributes.get("status");
        message= (String) attributes.get("message");
        path= (String) attributes.get("path");
        apiResult= new ApiResult(path,message,status);

        // attributes error varsa
        if(attributes.containsKey("errors")){
            List<FieldError> fieldErrorList= (List<FieldError>) attributes.get("errors");
            validationErrors=new HashMap<>();
            // for each dongu
            for(FieldError fieldError : fieldErrorList){
                validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            apiResult.setValidationErrors(validationErrors);
        }

        return apiResult;
    } //end handleErrorMethod
} // end CustomErrorHandleWebRequest

