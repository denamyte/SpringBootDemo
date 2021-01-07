package com.denamyte.example.demo.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private static final String NOT_FOUND_MESSAGE = "Information not found for number";

//    @ExceptionHandler(IndexOutOfBoundsException.class)
//    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = NOT_FOUND_MESSAGE)
//    public HashMap<String, String> handleIndexOutOfBoundsException(Exception e) {
//        HashMap<String, String> response = new HashMap<>();
//        response.put("message", NOT_FOUND_MESSAGE);
//        response.put("error", e.getClass().getSimpleName());
//        return response;
//    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public HashMap<String, String> handleNotFoundFlight(Exception e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Handled by global handler");
        response.put("error", e.getClass().getSimpleName());
        return response;
    }
}
