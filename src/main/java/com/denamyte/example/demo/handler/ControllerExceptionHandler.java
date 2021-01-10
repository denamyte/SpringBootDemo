package com.denamyte.example.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

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

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public HashMap<String, Object> handleValidationErrors(Exception e) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", "constraint violation");
        response.put("error", e.getClass().getSimpleName());
        ConstraintViolationException cve = (ConstraintViolationException) e;

        List<Map<String, String>> errorList = new ArrayList<>();
        for (ConstraintViolation<?> constraintViolation : cve.getConstraintViolations()) {
            Map<String, String> errMap = new LinkedHashMap<>();
            errMap.put("paramName", constraintViolation.getPropertyPath().toString());
            errMap.put("errorMessage", constraintViolation.getMessage());
            errMap.put("actualValue", constraintViolation.getInvalidValue().toString());
            errorList.add(errMap);
        }
        response.put("errorList", errorList);
        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HashMap<String, Object> handleOtherExceptions(Exception e) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("message", e.getMessage());
        response.put("error", e.getClass().getSimpleName());
        return response;
    }
}
