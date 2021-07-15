package by.it_academy.jd2.hw.example.airports.storage.api;

import by.it_academy.jd2.hw.example.airports.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
