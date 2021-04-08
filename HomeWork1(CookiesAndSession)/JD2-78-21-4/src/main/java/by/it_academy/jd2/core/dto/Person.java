package by.it_academy.jd2.core.dto;

import by.it_academy.jd2.utils.ApacheCommonsLang3;

/**
 *
 *  Home work №1
 *  Mk-JD2-78-21-4
 *  @author Olga Dobrodey
 *
 * Person class initializes Person with parameters
 * firstName, lastName, age;
 *
 */
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    /**
     * method getFirstName;
     * @return firstName - String
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * method setFirstName;
     * @param  firstName - String
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * method getLastName();
     * @return lastName - String
     */

    public String getLastName() {
        return lastName;
    }
    /**
     * method getLastName();
     * @param lastName - String
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * method getAge();
     * @return age - int
     */
    public int getAge() {
        return age;
    }

    /**
     * method getAge();
     * @param age - int
     */

    public void setAge(int age) {
        this.age = age;
    }
}
