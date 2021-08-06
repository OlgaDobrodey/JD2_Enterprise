package by.it_academy.jd2.core.service.people;


import by.it_academy.jd2.core.model.people.Role;
import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.people.IUserView;
import by.it_academy.jd2.storage.api.people.IUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.*;

public class UserView implements IUserView {

    private final IUserRepository repository;
    private PasswordEncoder passwordEncoder;

    public UserView(IUserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public User saveUser(User user) {
        return this.repository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        final List<User> userList = this.repository.findAll();
        return userList;
    }

    @Override
    public User searchUserLoginAndPsw(String login, String psw) {
        User user;
        try {
            user = this.repository.findByUsernameAndPassword(login, psw);
            return user;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public User searchUserLogin(String login) {
        User user;
        try {
            user = this.repository.findByUsername(login);
        } catch (NoSuchElementException e) {
            return null;
        }
        return user;
    }

    @Override
    public List<User> searchAllDoctors() {
        return this.repository.findAllByRole(Role.DOCTOR);
    }

    @Override
    public List<User> searchAllPatients() {
        return this.repository.findAllByRole(Role.PATIENT);
    }

    @Override
    public User findUserById(Integer id) {
        return this.repository.findUserById(id);
    }

    @Override
    public User updateUser(User user, Integer id) {

        User usersave = this.repository.findUserById(id);
        usersave.setSurname(user.getSurname());
        usersave.setUsername(user.getUsername());
        if (!usersave.getPassword().equals(user.getPassword())) {
            usersave.setPassword(this.passwordEncoder.encode(user.getPassword()));
        }
        usersave.setGiven_name(user.getGiven_name());
        usersave.setRole(user.getRole());
        usersave.setPosition(user.getPosition());
        usersave.setEmail(user.getEmail());
        usersave.setPhone(user.getPhone());
        usersave.setInfo(user.getInfo());

        return this.repository.save(usersave);
    }
}
