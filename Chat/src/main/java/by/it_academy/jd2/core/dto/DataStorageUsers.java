package by.it_academy.jd2.core.dto;

import java.util.HashSet;
import java.util.Set;

public class DataStorageUsers {


    private static Set<User> AllUsers = new HashSet<>();

    public static Set<User> getAllUsers() {
        return AllUsers;
    }

    public static void saveUsers(User user){
            AllUsers.add(user);
    }

    public static User searchUserLoginAndPsw(String login,String psw){
        for (User allUser : AllUsers) {
            if(allUser.getLogin().equals(login)&&(allUser.getPassword().equals(psw))){
                return allUser;
            }

        } return null;
    }
    public static User searchUserLogin(String login){
        for (User allUser : AllUsers) {
            if(allUser.getLogin().equals(login)){
                return allUser;
            }

        } return null;
    }






}
