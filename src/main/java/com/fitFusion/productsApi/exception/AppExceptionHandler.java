package com.fitFusion.productsApi.exception;

import com.fitFusion.productsApi.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class AppExceptionHandler {

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ApiResponse<String>> handleException(NullPointerException e){
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(500);
        response.setMessage(e.getLocalizedMessage());
        response.setData(null);
        log.error(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleException(Exception e)
    {
        ApiResponse<String> response = new ApiResponse<>();
        response.setStatus(500);
        response.setMessage(e.getLocalizedMessage());
        response.setData(null);
        log.error(e.getMessage());
        return  new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
