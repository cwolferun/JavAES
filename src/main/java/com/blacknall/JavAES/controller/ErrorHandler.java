package com.blacknall.JavAES.controller;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleThat(MethodArgumentNotValidException MANVE){
        return Map.of("Error",MANVE.getBindingResult().getFieldError().toString());
    }
}
