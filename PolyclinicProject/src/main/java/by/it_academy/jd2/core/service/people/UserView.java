package by.it_academy.jd2.core.service.people;


import by.it_academy.jd2.core.model.people.Role;
import by.it_academy.jd2.core.model.people.User;
import by.it_academy.jd2.core.service.api.people.IUserView;
import by.it_academy.jd2.storage.api.people.IUserRepository;


import java.util.*;

public class UserView implements IUserView {

    private final IUserRepository repository;

    public UserView(IUserRepository repository) {
        this.repository = repository;

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
    public User createUser( Map<String, Object> map) {
        User user = new User();
        user.setUsername((String)map.get("username"));

//
//                "password": $("#identification").val(),
//                "surname": $("#code_state").val(),
//                "given_name": $("#nationality").val(),
//                "role": $("#date_birthday").val(),
//                "position": $("#sex").val(),
//                "phone": $("#data_issue").val(),
//                "email": $("#data_expiry").val(),
//                "info": $("#place_birth").val(),

        return null;
    }
}
