package by.it_academy.jd2.hw.example.airports.view;

import by.it_academy.jd2.hw.example.airports.model.Flying;
import by.it_academy.jd2.hw.example.airports.storage.api.IFlyingsRepository;
import by.it_academy.jd2.hw.example.airports.view.api.IFlyingsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlyingsView implements IFlyingsView {
    private final IFlyingsRepository repository;

    public FlyingsView(IFlyingsRepository repository) {
        this.repository = repository;
    }

    @Override
    public long count(FlyingFilter filter){
        return this.repository.countByArrivalAirportOrDepartureAirport(
                filter.getAirportOut(),
                filter.getAirportIn()
        );
    }

    @Override
    public List<Flying> getList(FlyingFilter filter) {
        return this.repository.findAllByArrivalAirportOrDepartureAirport(
                filter.getAirportOut(),
                filter.getAirportIn(),
                PageRequest.of(filter.getPage(), 20)
        );
    }

    @Override
    public Flying get(Integer key) {
        return this.repository.getById(key);
    }

    @Transactional
    public void save(Flying flying){
        this.repository.save(flying);
    }

}
