package com.denamyte.example.demo.controllers.flights;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class FlightController {


    private final List<FlightInfo> flightInfoList = new ArrayList<>();

    private static final String NOT_FOUND_MESSAGE = "Flight not found for number";

    public FlightController() {
        flightInfoList.add(new FlightInfo("Delhi Indira Gandhi", "Stuttgart", "D80"));
        flightInfoList.add(new FlightInfo("Tokio Haneda", "Frankfurt", "110"));
        flightInfoList.add(new FlightInfo("Kilimanjaro Arusha", "Boston", "15"));
        flightInfoList.add(new FlightInfo("Berlin Schönefeld", "Tenerife", "15"));
    }

//    @GetMapping("flights/{id}")
//    public FlightInfo getFlightInfo (@PathVariable int id) {
//        return flightInfoList.get(id);
//    }

    @GetMapping("flights/{id}")
    public FlightInfo getFlightInfo(@PathVariable int id) {
        if (id > flightInfoList.size()) {
            throw new FlightNotFoundException("Flight not found for id =" + id);
        }
        return flightInfoList.get(id);
    }

//    @ExceptionHandler(IndexOutOfBoundsException.class)
//    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = NOT_FOUND_MESSAGE)
//    public HashMap<String, String> handleIndexOutOfBoundsException(Exception e) {
//        HashMap<String, String> response = new HashMap<>();
//        response.put("message", NOT_FOUND_MESSAGE);
//        response.put("error", e.getClass().getSimpleName());
//        return response;
//    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public HashMap<String, String> handleNotFoundFlight(Exception e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Handled by controller level handler");
        response.put("error", e.getClass().getSimpleName());
        return response;
    }
}
