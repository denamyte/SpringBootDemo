package com.denamyte.example.demo.controllers.flights;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightInfo {

    private String from;
    private String to;
    private String gate;

}
