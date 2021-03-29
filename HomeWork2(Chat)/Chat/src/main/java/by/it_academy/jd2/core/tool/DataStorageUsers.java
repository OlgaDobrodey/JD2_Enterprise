package by.it_academy.jd2.core.tool;

import by.it_academy.jd2.core.storage.AllUsers;
import by.it_academy.jd2.core.view.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Class contains method work with users
 */
public class DataStorageUsers {

    /**Method save users in application memory
     * @param user User
     */
    public static void saveUsers(User user){
        AllUsers.getAllUsers().add(user);
    }

    /**Method search user whith PSW and login in application memory
     * @param login user String
     * @param psw user String
     * @return user User
     */

    public static User searchUserLoginAndPsw(String login,String psw){
        for (User allUser : AllUsers.getAllUsers()) {
            if(allUser.getLogin().equals(login)&&(allUser.getPassword().equals(psw))){
                return allUser;
            }

        } return null;
    }
    /**Method search user with  and login in application memory
     * @param login user String
     * @return user User
     */


    public static User searchUserLogin(String login){
        for (User allUser : AllUsers.getAllUsers()) {
            if(allUser.getLogin().equals(login)){
                return allUser;
            }
        } return null;
    }


    /**
     * Method gets all user logins of the application
     * @return users Set
     */
    public static Set<String> getUsersLogin(){
        HashSet<String> usersLogin = new HashSet<>();
        for (User user : AllUsers.getAllUsers()) {
            usersLogin.add(user.getLogin());
        }
        return usersLogin;
    }

}
