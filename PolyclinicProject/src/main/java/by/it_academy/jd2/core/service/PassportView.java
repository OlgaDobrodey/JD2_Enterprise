package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.Passport;
import by.it_academy.jd2.core.service.api.IPassportView;
import by.it_academy.jd2.storage.api.IPassportRepository;

public class PassportView implements IPassportView {
    private IPassportRepository repository;

    public PassportView(IPassportRepository repository) {
        this.repository = repository;
    }

    @Override
    public void savePassport(Passport passport) {

    }
}
