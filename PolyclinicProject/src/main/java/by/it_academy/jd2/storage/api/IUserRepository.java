package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.core.model.Role;
import by.it_academy.jd2.core.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface   IUserRepository extends JpaRepository<User,String> {
    User findByLoginAndAndPassword(String login,String psw);
    List<User> findAllByRole(Role role);
}
