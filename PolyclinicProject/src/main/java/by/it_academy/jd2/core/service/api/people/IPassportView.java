package by.it_academy.jd2.core.service.api.people;

import by.it_academy.jd2.core.model.people.Passport;

import by.it_academy.jd2.core.model.people.User;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Map;

public interface IPassportView {
    List<Passport> findAllPassport();
    Passport findPassport(User user);



   Passport savePassport(Passport passport) throws DataIntegrityViolationException;
    void deletePassport(Integer id);
    Passport findPassportById(Integer id);
    Passport createPassport(Passport passport, Map<String, Object> map, User user );
}
