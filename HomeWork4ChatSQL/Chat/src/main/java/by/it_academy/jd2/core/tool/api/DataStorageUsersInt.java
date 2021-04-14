package by.it_academy.jd2.core.tool.api;

import by.it_academy.jd2.core.view.User;

import java.util.Set;

public interface DataStorageUsersInt {
    void saveUsers(User user);
    User searchUserLoginAndPsw(String login,String psw);
    User searchUserLogin(String login);
    Set<String> getUsersLogin();
    int deleteUser(String login);
}
