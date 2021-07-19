package by.it_academy.jd2.core.model.people;


import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;

@Entity(name = "User")
@Table(name = "users", schema = "polyclinic")
public class User {
    @Id
    @Generated(GenerationTime.NEVER)
    @Column(name = "login")
    private String login;
    @Column(name = "psw")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "surname")
    private String surname;
    @Column(name = "given_name")
    private String given_name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "info")
    private String info;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medical_card")
    private int madical_card;
    @Column(name = "position")
    private String position;
    @Column(name = "link")
    private String link;

    @OneToOne
    @JoinColumn(name = "address")
    private Address addresses;

//    @OneToOne
//    @JoinColumn(name = "id_passport")
//   // @Column(name = "passport")
//    private Passport passports;

    public User() {
    }

    public User(String login, String password, Role role, String surname, String given_name, String email, String phone, String info, String position, Address addresses) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.surname = surname;
        this.given_name = given_name;
        this.email = email;
        this.phone = phone;
        this.info = info;
        this.position = position;
        this.addresses = addresses;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getMadical_card() {
        return madical_card;
    }

    public void setMadical_card(int madical_card) {
        this.madical_card = madical_card;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", surname='" + surname + '\'' +
                ", given_name='" + given_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", info='" + info + '\'' +
                ", madical_card=" + madical_card +
                ", position='" + position + '\'' +
                ", link='" + link + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
