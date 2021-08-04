package by.it_academy.jd2.core.service.people;

import by.it_academy.jd2.core.model.people.Passport;
import by.it_academy.jd2.core.model.people.Sex;
import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.people.IPassportView;
import by.it_academy.jd2.storage.api.people.IPassportRepository;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
    public Passport savePassport(Passport passportSave) throws DataIntegrityViolationException{
      return this.repository.save(passportSave);
    }

    @Override
    public void deletePassport(Integer id) {
        this.repository.delete(repository.findPassportById(id));
    }

    @Override
    public Passport findPassportById(Integer id) {
        return this.repository.findPassportById(id);
    }


    @Override
    public Passport createPassport(Passport passport, Map<String, Object> map, User user) {
        passport.setId_passport((String) map.get("id_passport"));
        passport.setIdentification((String) map.get("identification"));
        passport.setCode_state((String) map.get("code_state"));
        passport.setNationality((String) map.get("nationality"));
        passport.setDate_birthday(LocalDate.parse((String) map.get("date_birthday")));
        passport.setPlace_birth((String) map.get("place_birth"));
        passport.setData_issue(LocalDate.parse((String) map.get("data_issue")));
        passport.setData_expiry(LocalDate.parse((String) map.get("data_expiry")));
        passport.setSex(Sex.valueOf((String) map.get("sex")));
        passport.setUsers(user);

        return passport;
    }
}
