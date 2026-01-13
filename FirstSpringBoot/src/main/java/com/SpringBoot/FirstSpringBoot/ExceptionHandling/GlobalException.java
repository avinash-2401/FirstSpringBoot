package com.SpringBoot.FirstSpringBoot.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    //EXCEPTION HANDLING METHOD
    @ExceptionHandler({userNotFoundException.class,IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<Map<String, Object>> HandalIllegelesArgumentExecption(Exception exception) {
        Map<String, Object> erroResponse = new HashMap<>();

        erroResponse.put("TimeStamp ", LocalDateTime.now());
        erroResponse.put("Status", HttpStatus.BAD_REQUEST.value());
        erroResponse.put("Error", "Bad request");
        erroResponse.put("MSG", exception.getMessage());
        return new ResponseEntity<>(erroResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> HttpMethodNotSupport(Exception exception) {
        Map<String, Object> erroResponse = new HashMap<>();

        erroResponse.put("TimeStamp ", LocalDateTime.now());
        erroResponse.put("Status", HttpStatus.METHOD_NOT_ALLOWED.value());
        erroResponse.put("Error", "not allowed for this EndPoint");
        erroResponse.put("MSG", exception.getMessage());
        return new ResponseEntity<>(erroResponse, HttpStatus.METHOD_NOT_ALLOWED);


    }

}
