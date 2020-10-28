package com.animalshop.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.animalshop.exception.ProductNotFoundException;
import com.animalshop.exception.ResponseError;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseError missingResource(Exception e) {
        return new ResponseError(e.getMessage());
    }
}
