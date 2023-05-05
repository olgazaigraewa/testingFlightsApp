package com.gridnine.testing;

import java.util.List;
import java.util.Set;

/**
 * Interface for flight filter
 */
public interface FlightFilter {

    void allSegmentsFlight(List<Flight> flights);

    Set<Flight> departureBeforeTheCurrentTime(List<Flight> flights);

    Set<Flight> arrivalDateBeforeDepartureDate(List<Flight> flights);

    Set<Flight> moreThanTwoHoursGroundTime(List<Flight> flights);
}
