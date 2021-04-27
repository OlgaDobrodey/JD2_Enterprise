package by.it_academy.jd2.core.dto.view.hibernate;

import by.it_academy.jd2.core.dto.view.Airports;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "airports")
@Table(name = "airports", schema = "bookings")
public class AirportsHibernate extends Airports {

    @Id
    @Column(name = "airport_code")
    private String airport_code;
    @Column(name = "airport_name")
    private String airport_name;
    @Column(name = "city")
    private String city;

    @Column(name = "coordinates")
    private String coordinates;
    @Column(name = "timezone")
    private String timezone;


    public AirportsHibernate() {
    }

    public String getAirport_code() {
        return airport_code;
    }

    public void setAirport_code(String airport_code) {
        this.airport_code = airport_code;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "AirportsHibernate{" +
                "airport_code='" + airport_code + '\'' +
                ", airport_name='" + airport_name + '\'' +
                ", city='" + city + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}

