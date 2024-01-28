package com.app.ecom.ecommercedemo.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.ecom.ecommercedemo.dto.GenericExceptionDto;
import com.app.ecom.ecommercedemo.exception.ProductNotFoundException;

@RestControllerAdvice
public class GenericControllerAdvices {
    
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    private GenericExceptionDto handleProductNotFoundException(ProductNotFoundException e){
        return new GenericExceptionDto(e.getMessage(),HttpStatus.NOT_FOUND);    
    }
}
