package by.it_academy.jd2.core.dto.view;

import java.awt.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Flights implements Serializable {
    private String flight_no;
    private String status;
    private LocalDate scheduled_departure1;
    private LocalDate scheduled_arrival1;
    private String scheduled_departure;
    private String scheduled_arrival;
    private String departure_airport;
    private String arrival_airport;

    public Flights() {
    }

    public String getFlight_no() {
        return flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScheduled_departure() {
        return scheduled_departure;
    }

    public void setScheduled_departure(String scheduled_departure) {
        this.scheduled_departure = scheduled_departure;
    }

    public String getScheduled_arrival() {
        return scheduled_arrival;
    }

    public void setScheduled_arrival(String scheduled_arrival) {
        this.scheduled_arrival = scheduled_arrival;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "flight_no='" + flight_no + '\'' +
                ", status='" + status + '\'' +
                ", scheduled_departure='" + scheduled_departure + '\'' +
                ", scheduled_arrival='" + scheduled_arrival + '\'' +
                ", departure_airport='" + departure_airport + '\'' +
                ", arrival_airport='" + arrival_airport + '\'' +
                '}';
    }
}
