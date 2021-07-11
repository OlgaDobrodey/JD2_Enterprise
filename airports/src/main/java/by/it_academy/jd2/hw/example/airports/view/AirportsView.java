package by.it_academy.jd2.hw.example.airports.view;

import by.it_academy.jd2.hw.example.airports.model.Airport;
import by.it_academy.jd2.hw.example.airports.storage.api.IAirportsRepository;
import by.it_academy.jd2.hw.example.airports.view.api.IAirportsView;

import java.util.List;

public class AirportsView implements IAirportsView {

    private final IAirportsRepository repository;

    public AirportsView(IAirportsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Airport> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Airport getCode(String code) {
        return this.repository.findById(code).orElseThrow(() -> new IllegalArgumentException("Ошибка"));
    }
    public void saveAirport(Airport airport){
        this.repository.save(airport);
    }


}
