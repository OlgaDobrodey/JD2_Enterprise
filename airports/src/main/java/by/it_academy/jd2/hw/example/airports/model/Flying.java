package by.it_academy.jd2.hw.example.airports.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Flying")
@Table(name = "flights", schema = "bookings")
public class Flying implements Serializable {

    @Id
    @Column(name = "flight_id")
    private Integer flightId; //Идентификатор рейса

    @Column(name = "flight_no")
    private String flightNo; //Номер рейса

    @Column(name = "scheduled_departure")
    private String scheduledDeparture; //Время вылета по расписанию

    @Column(name = "scheduled_arrival")
    private String scheduledArrival; //Время прилёта по расписанию

    @Column(name = "departure_airport")
    private String departureAirport; //Аэропорт отправления

    @Column(name = "arrival_airport")
    private String arrivalAirport; //Аэропорт прибытия

    @Column(name = "status")
    private String status; //Статус рейса

    @Column(name = "aircraft_code")
    private String aircraftCode; //Код самолета, IATA

    @Column(name = "actual_departure")
    private String actualDeparture; //Фактическое время вылета

    @Column(name = "actual_arrival")
    private String actualArrival; //Фактическое время прилёта


    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getScheduledDeparture() {
        return scheduledDeparture;
    }

    public void setScheduledDeparture(String scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    public String getScheduledArrival() {
        return scheduledArrival;
    }

    public void setScheduledArrival(String scheduledArrival) {
        this.scheduledArrival = scheduledArrival;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getActualDeparture() {
        return actualDeparture;
    }

    public void setActualDeparture(String actualDeparture) {
        this.actualDeparture = actualDeparture;
    }

    public String getActualArrival() {
        return actualArrival;
    }

    public void setActualArrival(String actualArrival) {
        this.actualArrival = actualArrival;
    }
}
