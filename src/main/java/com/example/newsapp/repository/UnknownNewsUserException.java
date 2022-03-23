package com.example.newsapp.repository;

public class UnknownNewsUserException extends RuntimeException {
    public UnknownNewsUserException(String msg) {
        super(msg);
    }
}
