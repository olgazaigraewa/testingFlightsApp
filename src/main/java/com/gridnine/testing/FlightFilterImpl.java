package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class for flight filter
 */
public class FlightFilterImpl implements FlightFilter {
    Set<Flight> flightSet = new HashSet<>();
    List<Segment> segs = new ArrayList<>();
    LocalDateTime time = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = getDateFormatter();

    /**
     * Method for obtaining all flight segments
     *
     * @param flights tested
     */
    @Override
    public void allSegmentsFlight(List<Flight> flights) {
        for (Flight flight : flights) {
            System.out.println("Flight number - " + flight.getId());
            for (int i = 0; i < flight.getSegments().size(); i++) {
                System.out.println(flight.getSegments().get(i));
            }
        }
    }

    /**
     * Method for to get information about departures that should be before the current time
     *
     * @param flights tested
     * @return found flightSet
     */
    @Override
    public Set<Flight> departureBeforeTheCurrentTime(List<Flight> flights) {
        for (Flight flight : flights) {
            segs.addAll(flight.getSegments());
            while (segs.size() > 0) {
                LocalDateTime dep = segs.get(0).getDepartureDate();
                LocalDateTime arr = segs.remove(0).getArrivalDate();
                if (dep.isBefore(time)) {
                    getRightFLight(flight, dep, arr);
                    flightSet.add(flight);
                }
            }

        }
        return flightSet;
    }

    /**
     * Method for obtaining segments with the arrival date before the departure date
     *
     * @param flights tested
     * @return found flightSet
     */
    @Override
    public Set<Flight> arrivalDateBeforeDepartureDate(List<Flight> flights) {
        for (Flight flight : flights) {
            segs.addAll(flight.getSegments());
            while (segs.size() > 0) {
                LocalDateTime dep = segs.get(0).getDepartureDate();
                LocalDateTime arr = segs.remove(0).getArrivalDate();
                if (arr.isBefore(dep)) {
                    getRightSegment(flight, dep, arr);
                    flightSet.add(flight);
                }
            }

        }
        return flightSet;
    }

    /**
     * Method of obtaining a flight with more than two hours of ground time
     *
     * @param flights tested
     * @return found flightSet
     */

    @Override
    public Set<Flight> moreThanTwoHoursGroundTime(List<Flight> flights) {
        for (Flight flight : flights) {
            segs.addAll(flight.getSegments());
            if (segs.size() > 2) {
                while (segs.size() > 2) {
                    LocalDateTime arr = segs.remove(1).getArrivalDate();
                    LocalDateTime dep = segs.remove(1).getDepartureDate();
                    if (arr.plusHours(2).isBefore(dep)) {
                        getGroundTime(flight, arr, dep);
                        flightSet.add(flight);
                    }
                }
            }
        }
        return flightSet;
    }

    private void getRightFLight(Flight flight, LocalDateTime dep, LocalDateTime arr) {
        System.out.println("Flight number - " + flight.getId() + "\n" + "Departure time: " + dateTimeFormatter.format(dep)
                + "\n" + "Current time: " + dateTimeFormatter.format(arr) + "\n");
    }

    private void getRightSegment(Flight flight, LocalDateTime dep, LocalDateTime arr) {
        System.out.println("Flight number - " + flight.getId() + "\n" + "Departure time: " + dateTimeFormatter.format(dep)
                + "\n" + "Arrival time: " + dateTimeFormatter.format(arr) + "\n");
    }

    private void getGroundTime(Flight flight, LocalDateTime arr, LocalDateTime dep) {
        System.out.println("Flight number - " + flight.getId() + "\n" + "Arrival time: " + dateTimeFormatter.format(arr)
                + "\n" + "Departure time: " + dateTimeFormatter.format(dep) + "\n");

    }

    private DateTimeFormatter getDateFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
    }
}
