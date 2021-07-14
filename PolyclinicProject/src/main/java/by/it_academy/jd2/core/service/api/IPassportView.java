package by.it_academy.jd2.core.service.api;

import by.it_academy.jd2.core.model.Passport;
import by.it_academy.jd2.core.model.User;

import java.util.List;

public interface IPassportView {
    List<Passport> findAllPassport();
    Passport findPassport(User user);
}
