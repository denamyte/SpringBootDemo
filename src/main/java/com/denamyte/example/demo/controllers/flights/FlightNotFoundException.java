package com.denamyte.example.demo.controllers.flights;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
class FlightNotFoundException extends RuntimeException {
    public FlightNotFoundException(String s) {
        super(s);
    }
}
