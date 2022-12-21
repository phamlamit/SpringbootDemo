package com.example.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionController {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerExeption(Exception ex) {
        ex.printStackTrace();
        return "null-pointer";
    }
}
