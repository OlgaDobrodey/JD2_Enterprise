package by.it_academy.jd2.core.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;


/**
 * Class user
 * chat user
 */

@Entity(name = "User")
@Table(name = "users", schema = "chat")
public class User implements Serializable {

    @Id
    @Generated(GenerationTime.NEVER)
    @Column(name = "login")
    private String login;
    @Column(name = "psw")
    private String password;
    @Column(name = "name_user")
    private String name;
    @Column(name = "birthday")
    private Date birthday;


    public User() {
    }

    public User(String login, String password, String name, Date birthday) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
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
        return birthday.toString();
    }
    /**
     * This method set Birthday user
     * @param birthday user String
     */

    public void setBirthday(String birthday) {
        this.birthday = Date.valueOf(birthday);
    }

    @Override
    public String toString() {
        return String.format(" %s(имя %s)",getLogin(),getName());
    }
}
