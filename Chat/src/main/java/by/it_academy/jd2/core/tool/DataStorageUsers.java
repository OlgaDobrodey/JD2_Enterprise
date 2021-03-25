package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.core.storage.AllUsers;
import by.it_academy.jd2.core.view.User;

import java.util.HashSet;
import java.util.Set;

public class DataStorageUsers {


    public static void saveUsers(User user){
        AllUsers.getAllUsers().add(user);
    }

    public static User searchUserLoginAndPsw(String login,String psw){
        for (User allUser : AllUsers.getAllUsers()) {
            if(allUser.getLogin().equals(login)&&(allUser.getPassword().equals(psw))){
                return allUser;
            }

        } return null;
    }
    public static User searchUserLogin(String login){
        for (User allUser : AllUsers.getAllUsers()) {
            if(allUser.getLogin().equals(login)){
                return allUser;
            }
        } return null;
    }
    public static Set<String> getUsersLogin(){
        HashSet<String> usersLogin = new HashSet<>();
        for (User user : AllUsers.getAllUsers()) {
            usersLogin.add(user.getLogin());

        }
        return usersLogin;
    }

}
