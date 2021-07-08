package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.core.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassportRepository  extends JpaRepository<Passport,String> {

}
