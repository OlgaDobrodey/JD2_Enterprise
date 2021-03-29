package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.view.User;

import java.util.HashSet;
import java.util.Set;


public class AllUsers {
    private static Set<User> AllUsers;

    private AllUsers() {
    }



    public static Set<User> getAllUsers() {
        if (AllUsers == null) {
            synchronized (AllUsers.class) {
                if (AllUsers == null) {
                    AllUsers = new HashSet<User>();
                }

            }
        }
        return AllUsers;
    }
}
