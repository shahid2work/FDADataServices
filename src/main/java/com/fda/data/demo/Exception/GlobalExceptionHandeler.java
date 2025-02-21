package com.fda.data.demo.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

@ControllerAdvice
public class GlobalExceptionHandeler {

    @ExceptionHandler({ ApiException.class, RuntimeException.class, Exception.class })
    public final ResponseEntity<String> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        return new ResponseEntity<>(ex.getMessage(), headers, status);
    }
}
