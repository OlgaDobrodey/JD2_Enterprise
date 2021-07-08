package by.it_academy.jd2.core.service.api;




import by.it_academy.jd2.core.model.User;

import java.util.List;

public interface IUserView {
//    List<User> getAllUsers();
//    void saveUsers(User user);
    User searchUserLoginAndPsw(String login, String psw);
    User searchUserLogin(String login);
    List<User> searchAllDoctors();
    List<User> searchAllPatients();
    //void saveUserChange(User user, String atribut, String value);
//    Set<String> getUsersLogin();
//    void deleteUser(String login);
}
