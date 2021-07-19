package by.it_academy.jd2.core.service.api;

import by.it_academy.jd2.core.model.people.Passport;
import by.it_academy.jd2.core.model.people.Sex;
import by.it_academy.jd2.core.model.people.User;

import java.time.LocalDate;
import java.util.List;

public interface IPassportView {
    List<Passport> findAllPassport();
    Passport findPassport(User user);
    Boolean findPassportByIdOrIdentification(String id_passport, String identification);
    Passport savePassport(String id_passport, String identification, String code_state,
                          String nationality, LocalDate date_birthday, Sex sex,
                          LocalDate data_issue, LocalDate data_expiry, String place_birth, User users);
}
