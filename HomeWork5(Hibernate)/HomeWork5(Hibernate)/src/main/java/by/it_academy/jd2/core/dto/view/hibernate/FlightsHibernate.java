package by.it_academy.jd2.core.dto.view.hibernate;

import by.it_academy.jd2.core.dto.view.Flights;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "flight")
@Table(name = "flights_v", schema = "bookings")
public class FlightsHibernate implements Serializable {

    @Id
    @Column(name = "flight_id")
    private Integer flight_id;
    @Column(name = "flight_no")
    private String flight_no;
    @Column(name = "status")
    private String status;
    @Column(name = "scheduled_departure")
    private String scheduled_departure;
    @Column(name = "scheduled_arrival")
    private String scheduled_arrival;
    @Column(name = "departure_airport")
    private String departure_airport;
    @Column(name = "arrival_airport")
    private String arrival_airport;
    @Column(name = "departure_city")
    private String departure_city;
    @Column(name = "arrival_city")
    private String arrival_city;

    public FlightsHibernate() {
    }

    public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
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

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }

    @Override
    public String toString() {
        return "FlightsHibernate{" +
                "flight_id=" + flight_id +
                ", flight_no='" + flight_no + '\'' +
                ", status='" + status + '\'' +
                ", scheduled_departure='" + scheduled_departure + '\'' +
                ", scheduled_arrival='" + scheduled_arrival + '\'' +
                ", departure_airport='" + departure_airport + '\'' +
                ", arrival_airport='" + arrival_airport + '\'' +
                ", departure_city='" + departure_city + '\'' +
                ", arrival_city='" + arrival_city + '\'' +
                '}';
    }
}
