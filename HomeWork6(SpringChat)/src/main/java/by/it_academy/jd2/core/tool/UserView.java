package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.core.tool.api.IUserView;
import by.it_academy.jd2.storage.api.IUserRepository;

import java.sql.Date;
import java.util.*;

public class UserView implements IUserView {

    private final IUserRepository repository;

    public UserView(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getAllUsers() {
        final List<User> userList = this.repository.findAll();
        return null;
    }

    public void saveUsers(User user) {
        User userSave = this.repository.save(new User(user.getLogin(), user.getPassword(), user.getName(), Date.valueOf(user.getBirthday())));


    }

    public User searchUserLoginAndPsw(String login, String psw) {
        User user;
        try {
            user = this.repository.findById(login).get();
            if (user.getPassword().equals(psw)) {
                return user;
            }
        } catch (NoSuchElementException e) {
            return null;
        }
        return null;
    }

    public User searchUserLogin(String login) {
        User user;
        try {
            user = this.repository.findById(login).get();
        } catch (NoSuchElementException e) {
            return null;
        }
        return user;
    }

    public Set<String> getUsersLogin() {
        final List<User> users = this.repository.findAll();
        Set<String> setLoginUsers = new HashSet<>();
        for (User user : users) {
            setLoginUsers.add(user.getLogin());
        }
        return setLoginUsers;
    }

    public void deleteUser(String login) {
        this.repository.deleteById(login);
    }

}
