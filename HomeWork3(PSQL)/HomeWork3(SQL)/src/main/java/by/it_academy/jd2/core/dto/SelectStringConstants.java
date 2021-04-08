package by.it_academy.jd2.core.dto;

public class SelectStringConstants {
    public static String listAllAirportsOrderByCity ="Select * from airports order by city";
    public static String MaxMinScheduled="select max(scheduled_departure), min(scheduled_departure),max(scheduled_arrival),min(scheduled_arrival) from flights";
}
