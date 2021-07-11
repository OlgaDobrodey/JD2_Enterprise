package by.it_academy.jd2.hw.example.airports.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Airport")
@Table(name = "airports", schema = "bookings")
public class Airport implements Serializable {

    @Id
    @Generated(GenerationTime.NEVER)
    @Column(name = "airport_code")
    private String code; //Код аэропорта

    @Column(name = "airport_name")
    private String name; //Название аэропорта

    @Column(name = "city")
    private String city;        // Город

    @Column(name = "timezone")
    private String timezone;    //Часовой пояс аэропорта

//    @Column(name = "coordinates")
//    private Point coordinates; //Координаты аэропорта (долгота и широта)

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

//    public Point getCoordinates() {
//        return coordinates;
//    }
//
//    public void setCoordinates(Point coordinates) {
//        this.coordinates = coordinates;
//    }

    @Override
    public String toString() {
        return "Airport{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", timezone='" + timezone + '\'' +
//                ", coordinates=" + coordinates +
                '}';
    }
}
