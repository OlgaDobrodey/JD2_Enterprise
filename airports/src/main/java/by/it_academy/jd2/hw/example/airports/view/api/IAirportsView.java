package by.it_academy.jd2.hw.example.airports.view.api;

import by.it_academy.jd2.hw.example.airports.model.Airport;

import java.util.List;

public interface IAirportsView {
    List<Airport> getAll();
    Airport getCode(String code);
    void saveAirport(Airport airport);
}

