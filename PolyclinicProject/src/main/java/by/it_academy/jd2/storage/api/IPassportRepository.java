package by.it_academy.jd2.storage.api;


import by.it_academy.jd2.core.model.Passport;
import by.it_academy.jd2.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPassportRepository extends JpaRepository<Passport,String> {
    Passport findPassportByUsers(User user);
    Passport findPassportByIdentification(String identification);

}
