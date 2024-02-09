package com.develhope.SpringAdvanced0104.controllers;
import com.develhope.SpringAdvanced0104.entities.FlightEntity;
import com.develhope.SpringAdvanced0104.entities.Status;
import com.develhope.SpringAdvanced0104.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class FlightController {

    @Autowired
    private FlightService service;

    @PostMapping("/create/severalflights")
    public void addFiftyFlights(@RequestParam(required = false) Integer flightNumber) {
        service.addRandomFlights(flightNumber);
    }


    @GetMapping("/show/flightsbystatus")
    public @ResponseBody List<FlightEntity> showFlightsBasedOnTwoEnumValues(
            @RequestParam(name = "p1") Status p1, @RequestParam(name = "p2") Status p2
            ) {
        return service.showFlightsBasedOnTwoEnumValues(p1,p2);
    }

    @GetMapping("/show/ontimeflights")
    public @ResponseBody List<FlightEntity> showOnTimeFlights() {
        return service.showOnTimeFlights();
    }

    @GetMapping("show/paginatedflights")
    public @ResponseBody Page<FlightEntity> showPaginatedFlights(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size) {
        return service.showPaginatedFlights(page, size);
    }
}

