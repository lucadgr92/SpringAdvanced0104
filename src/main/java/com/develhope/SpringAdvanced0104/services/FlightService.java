package com.develhope.SpringAdvanced0104.services;

import com.develhope.SpringAdvanced0104.entities.FlightEntity;
import com.develhope.SpringAdvanced0104.entities.Status;
import com.develhope.SpringAdvanced0104.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repo;

    public void addRandomFlights(Integer flightNumber) {
        Status[] statusList = {Status.ONTIME, Status.CANCELED, Status.DELAYED};
        int var = 0;
        if (flightNumber == null) {
            flightNumber = 100;
        }
        while (var < flightNumber) {
            FlightEntity flight = new FlightEntity();
            flight.setDescription(UUID.randomUUID().toString());
            flight.setFromAirport(UUID.randomUUID().toString());
            flight.setToAirport(UUID.randomUUID().toString());
            flight.setFlightStatus(statusList[ThreadLocalRandom.current().nextInt(statusList.length)]);
            repo.save(flight);
            var += 1;
        }
    }

    public Page<FlightEntity> showPaginatedFlights(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size, Sort.by("fromAirport").ascending());
        return repo.findAll(pageable);
    }

    public List<FlightEntity> showFlightsBasedOnTwoEnumValues(Status p1, Status p2) {
        return repo.showFlightsBasedOnTwoEnumValues(p1,p2);
    }

    public List<FlightEntity> showOnTimeFlights() {
        return repo.findFlightByStatus(Status.ONTIME);
    }
}
