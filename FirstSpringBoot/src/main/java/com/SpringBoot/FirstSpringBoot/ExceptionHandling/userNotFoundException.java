package com.SpringBoot.FirstSpringBoot.ExceptionHandling;

public class userNotFoundException extends RuntimeException{

    public userNotFoundException(String message) {
        super(message);
    }
}
