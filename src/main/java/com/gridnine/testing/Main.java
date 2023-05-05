package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Flight> flights =  FlightBuilder.createFlights();
        FlightFilterImpl flightFilter = new FlightFilterImpl();
        System.out.println("Initial test set of flights");
        flightFilter.allSegmentsFlight(flights);
        System.out.println("Flight with departure before the current time");
        flightFilter.departureBeforeTheCurrentTime(flights);
        System.out.println("Segments with arrival date before departure date");
        flightFilter.arrivalDateBeforeDepartureDate(flights);
        System.out.println("A flight with more than two hours ground time");
        flightFilter.moreThanTwoHoursGroundTime(flights);

    }
}
