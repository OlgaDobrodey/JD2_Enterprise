package by.it_academy.jd2.storage.api.people;

import by.it_academy.jd2.core.model.people.Address;
import by.it_academy.jd2.core.model.people.Role;
import by.it_academy.jd2.core.model.people.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

    List<User> findAllByRole(Role role);

    User findByUsername(String username);

    List<User> findAllByAddresses(Address address);

}
