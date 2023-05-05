package com.gridnine.testing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Class for testing flight filter methods
 */
public class FlightFilterImplTest {
    private final FlightFilter flightFilter = new FlightFilterImpl();
    private final List<Flight> flights = new ArrayList<>();
    public final List<Segment> segs = new ArrayList<>();
    LocalDateTime time = LocalDateTime.now();

    @Test
    @DisplayName("Checking  the method for receiving departures up to the current time ")
    public void departureBeforeTheCurrentTime() {
        Segment segment = new Segment(LocalDateTime.now().minusHours(6),LocalDateTime.now());
        segs.add(segment);
        Set<Flight> filteredFlights = flightFilter.departureBeforeTheCurrentTime(flights);
        assertTrue(filteredFlights.isEmpty());
    }

    @Test
    @DisplayName("Checking  the method for obtaining segments with the arrival date before the departure date ")
    public void arrivalDateBeforeDepartureDate() {
        Segment segment = new Segment(LocalDateTime.now(),LocalDateTime.now().minusHours(2));
        segs.add(segment);
        Set<Flight> filteredFlights = flightFilter.arrivalDateBeforeDepartureDate(flights);
        assertTrue(filteredFlights.isEmpty());
    }

    @Test
    @DisplayName("Checking the method of obtaining a flight with more than two hours of ground time ")
    public void moreThanTwoHoursGroundTime() {
        Segment segment1 = new Segment(time.plusHours(2), time);
        Segment segment2 = new Segment(time.plusHours(2).plusMinutes(2), time.plusHours(6));
        segs.add(segment1);
        segs.add(segment2);
        Set<Flight> filteredFlights = flightFilter.moreThanTwoHoursGroundTime(flights);
        assertTrue(filteredFlights.isEmpty());
    }


}
