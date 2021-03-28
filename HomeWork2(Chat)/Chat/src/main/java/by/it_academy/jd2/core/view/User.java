package by.it_academy.jd2.core.view;
/**
 *
 *  Home work №2
 *  Chat
 *  @author Olga Dobrodey
 *
 * User class initializes User with parameters
 * name, login, password, birthday;
 *
 */
public class User {

    private String name;
    private String login;
    private String password;
    private String birthday;

    public User() {
    }
    /**
     * method getName();
     * @return name - String
     */
    public String getName() {
        return name;
    }

    /**
     * method setName
     * @param name String
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * method getLogin
     * @return login String
     */

    public String getLogin() {
        return login;
    }
    /**
     * method setLogin
     * @param login String
     */

    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * method getPassword()
     * @return password String
     */

    public String getPassword() {
        return password;
    }
    /**
     * method setPassword()
     * @param password String
     */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * method getBirthday()
     * @return birthday String
     */
    public String getBirthday() {
        return birthday;
    }
    /**
     * method setBirthday()
     * @param birthday String
     */

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * method toString
     * @return getLogin(имя getName)",getLogin(),getName()
     */

    @Override
    public String toString() {
        return String.format(" %s(имя %s)",getLogin(),getName());
    }
}
