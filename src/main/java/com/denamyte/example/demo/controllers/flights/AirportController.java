package com.denamyte.example.demo.controllers.flights;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class AirportController {

    private final List<AirportInfo> airportInfoList = new ArrayList<>();
    private static final String SERVICE_WARNING_MESSAGE = "Berlin Schönefeld is closed for service today";

    public AirportController() {
        airportInfoList.add(new AirportInfo("Kilimanjaro Arusha", "ARK", "HTAR"));
        airportInfoList.add(new AirportInfo("Berlin Schönefeld", "TXL", "EDDT"));
        airportInfoList.add(new AirportInfo("Delhi Indira Gandhi", "DEL", "VIDP"));
        airportInfoList.add(new AirportInfo("Tokio Haneda", "HND", "RJTT"));
    }

    @GetMapping("airports/{id}")
    public AirportInfo getAirportInfo(@PathVariable int id) {
        AirportInfo airportInfo = airportInfoList.get(id);
        if (Objects.equals(airportInfo.getName(), "Berlin Schönefeld")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, SERVICE_WARNING_MESSAGE);
        }
        return airportInfo;
    }

}
