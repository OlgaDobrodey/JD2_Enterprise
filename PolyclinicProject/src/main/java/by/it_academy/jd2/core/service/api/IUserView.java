package by.it_academy.jd2.core.service.api;


import by.it_academy.jd2.core.model.people.Address;
import by.it_academy.jd2.core.model.people.Role;
import by.it_academy.jd2.core.model.people.User;

import java.util.List;

public interface IUserView {

    User saveUser(String login, String password, Role role, String surname,
                  String given_name, String email, String phone, String info,
                  String position, Address addresses);

    User searchUserLoginAndPsw(String login, String psw);

    User searchUserLogin(String login);

    List<User> searchAllDoctors();

    List<User> searchAllPatients();
    //void saveUserChange(User user, String atribut, String value);
//    Set<String> getUsersLogin();
//    void deleteUser(String login);  //    List<User> getAllUsers();

}
