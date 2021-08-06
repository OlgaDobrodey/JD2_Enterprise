package by.it_academy.jd2.core.service.api.people;


import by.it_academy.jd2.core.model.people.Address;
import by.it_academy.jd2.core.model.people.Passport;
import by.it_academy.jd2.core.model.people.Role;
import by.it_academy.jd2.core.model.people.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IUserView {

    User saveUser(User user);

    User searchUserLoginAndPsw(String login, String psw);

    User searchUserLogin(String login);

    List<User> searchAllDoctors();

    List<User> searchAllPatients();

    List<User> getAllUsers();

    User findUserById(Integer id);

    User updateUser(User user, Integer id);




}
