package com.example.newsapp.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NewsControllerAdvice {
    private static final Logger log = LoggerFactory.getLogger(NewsControllerAdvice.class);
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(RuntimeException x) {
        log.error("Unhandled Exception", x);
        return "errorpage";
    }
}
