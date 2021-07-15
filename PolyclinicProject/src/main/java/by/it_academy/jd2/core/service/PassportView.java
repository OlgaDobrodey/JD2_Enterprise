package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.Passport;
import by.it_academy.jd2.core.model.Sex;
import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.core.service.api.IPassportView;
import by.it_academy.jd2.storage.api.IPassportRepository;

import java.time.LocalDate;
import java.util.List;

public class PassportView implements IPassportView {
    public PassportView(IPassportRepository repository) {
        this.repository = repository;
    }

    private final IPassportRepository repository;
    @Override
    public List<Passport> findAllPassport() {
        return this.repository.findAll();
    }

    @Override
    public Passport findPassport(User user) {
        return this.repository.findPassportByUsers(user);
    }

    @Override
    public Boolean findPassportByIdOrIdentification(String id_passport, String identification) {
        final Passport byIdentification = this.repository.findPassportByIdentification(identification);
        if(byIdentification!=null){return true;}
        final boolean present = this.repository.findById(id_passport).isPresent();
        if(this.repository.findById(id_passport).isPresent()){return true;}
        return false;
    }

    @Override
    public Passport savePassport(String id_passport, String identification, String code_state, String nationality, LocalDate date_birthday, Sex sex, LocalDate data_issue, LocalDate data_expiry, String place_birth, User users)
    {
//        Passport passport = new Passport();

        return this.repository.save(new Passport(id_passport,  identification,  code_state,  nationality,  date_birthday, sex,data_issue,  data_expiry, place_birth,users));
    }
}
