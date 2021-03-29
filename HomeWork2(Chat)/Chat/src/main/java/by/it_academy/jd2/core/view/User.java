package by.it_academy.jd2.core.view;
/**
 * Class user
 * chat user
 */
public class User {

    private String name;
    private String login;
    private String password;
    private String birthday;


    public User() {
    }


    /**This method get Name user
     * @return  user name String
     */
    public String getName() {
        return name;
    }


    /**This method set Name user
     * @param name user String
     */
    public void setName(String name) {
        this.name = name;
    }


    /**This method get login user
     * @return user login String
     */
    public String getLogin() {
        return login;
    }

    /**
     * This method set login user
     * @param login user String
     */

    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * This method get PSW user
     * @return password user String
     */
    public String getPassword() {
        return password;
    }


    /**This method set PSW user
     * @param password user String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method get Birthday user
     * @return birthday user String
     */
    public String getBirthday() {
        return birthday;
    }
    /**
     * This method set Birthday user
     * @param birthday user String
     */

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }



    @Override
    public String toString() {
        return String.format(" %s(имя %s)",getLogin(),getName());
    }
}
