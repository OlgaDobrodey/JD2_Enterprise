package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.core.storage.AllUsers;
import by.it_academy.jd2.core.view.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Class DataStorageUsers contains methods foe work Users
 */
public class DataStorageUsers {

    /**
     * method saveUsers
     * Method save User in Set<User> AllUsers
     * @param user -User
     */

    public static void saveUsers(User user){
        AllUsers.getAllUsers().add(user);
    }

    /**
     * method  searchUserLoginAndPsw
     * finds User whith a login and a psw in Set<User> AllUsers
     * @param login -String
     * @param psw -String
     * @return allUser - User  or null (if user with login and psw not in Set<User> AllUsers)
     */

    public static User searchUserLoginAndPsw(String login,String psw){
        for (User allUser : AllUsers.getAllUsers()) {
            if(allUser.getLogin().equals(login)&&(allUser.getPassword().equals(psw))){
                return allUser;
            }

        } return null;
    }

    /**
     * method searchUserLogin
     * finds User whith a login in Set<User> AllUsers
     * @param login String
     * @return allUser - User  or null (if user with a login not in Set<User> AllUsers)
     */
    public static User searchUserLogin(String login){
        for (User allUser : AllUsers.getAllUsers()) {
            if(allUser.getLogin().equals(login)){
                return allUser;
            }
        } return null;
    }

    /**
     * method getUsersLogin
     * @return usersLogin - Set<String> - set all User's login
     */
    public static Set<String> getUsersLogin(){
        HashSet<String> usersLogin = new HashSet<>();
        for (User user : AllUsers.getAllUsers()) {
            usersLogin.add(user.getLogin());
        }
        return usersLogin;
    }

}
