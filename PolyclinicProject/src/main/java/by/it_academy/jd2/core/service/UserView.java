package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.Address;
import by.it_academy.jd2.core.model.Role;
import by.it_academy.jd2.core.model.User;
import by.it_academy.jd2.core.service.api.IUserView;
import by.it_academy.jd2.storage.api.IUserRepository;

import java.util.*;

public class UserView implements IUserView {

    private final IUserRepository repository;
    //  private final TableMetadataRepository tableRepository;

    public UserView(IUserRepository repository) {
        this.repository = repository;

    }

    @Override
    public User saveUser(String login, String password, Role role, String surname, String given_name,
                         String email, String phone, String info, String position, Address addresses) {
        final User user = new User(login,password,role,surname,given_name,email,phone,info,position,addresses);
        return this.repository.save(user);
    }

    //
//    @Override
//    public List<User> getAllUsers() {
//        final List<User> userList = this.repository.findAll();
//        return null;
//    }
//
//    public void saveUsers(User user) {
//        User userSave = this.repository.save(new User(user.getLogin(), user.getPassword(), user.getName(), Date.valueOf(user.getBirthday())));
//
//
//    }
//
    @Override
    public User searchUserLoginAndPsw(String login, String psw) {
        User user;
        try {
            user = this.repository.findByLoginAndAndPassword(login, psw);
            return user;
        } catch (NoSuchElementException e) {
            return null;

        }
    }

    @Override
    public User searchUserLogin(String login) {
        User user;
        try {
            user = this.repository.findById(login).get();
        } catch (NoSuchElementException e) {
            return null;
        }
        return user;
    }

    @Override
    public List<User> searchAllDoctors(){
        return this.repository.findAllByRole(Role.DOCTOR);
    }

    @Override
    public List<User> searchAllPatients() {
        return this.repository.findAllByRole(Role.PATIENT);
    }



    //    public Set<String> getUsersLogin() {
//        final List<User> users = this.repository.findAll();
//        Set<String> setLoginUsers = new HashSet<>();
//        for (User user : users) {
//            setLoginUsers.add(user.getLogin());
//        }
//        return setLoginUsers;
//    }
//
//    public void deleteUser(String login) {
//        this.repository.deleteById(login);
//    }

}
