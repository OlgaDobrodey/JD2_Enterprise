package by.it_academy.jd2.core.tool.api;

import by.it_academy.jd2.core.model.User;


import java.util.List;
import java.util.Set;

public interface IUserView {
    List<User> getAllUsers();
    void saveUsers(User user);
    User searchUserLoginAndPsw(String login,String psw);
    User searchUserLogin(String login);
    Set<String> getUsersLogin();
    void deleteUser(String login);
}
