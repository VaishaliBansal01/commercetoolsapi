package com.demo.CT.exceptions;


import com.demo.CT.customersigninsignup.ApiREsponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiREsponse> handleUserNotFoundException(CustomerNotFoundException ex) {

        return new ResponseEntity<ApiREsponse>(new ApiREsponse(ex.getMessage(),false), HttpStatus.NOT_FOUND);
    }

}
