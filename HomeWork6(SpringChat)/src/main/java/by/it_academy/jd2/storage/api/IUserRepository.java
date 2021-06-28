package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,String> {


}
