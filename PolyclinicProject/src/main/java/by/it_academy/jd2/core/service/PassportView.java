package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.Passport;
import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.core.service.api.IPassportView;
import by.it_academy.jd2.storage.api.IPassportRepository;

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
}
