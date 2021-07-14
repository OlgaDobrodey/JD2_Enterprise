package by.it_academy.jd2.core.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "passports", schema = "polyclinic")
public class Passport {
    @Id
    @Generated(GenerationTime.NEVER)
    private String id_passport;
    private String identification;
    private String code_state;
    private String nationality;
    private LocalDate date_birthday;
    private String sex;
    private LocalDate data_issue;
    private LocalDate data_expiry;
    private String place_birth;

    @OneToOne
    @JoinColumn(name = "login_user")
    private User users;


    public String getId_passport() {
        return id_passport;
    }

    public void setId_passport(String id_passport) {
        this.id_passport = id_passport;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getCode_state() {
        return code_state;
    }

    public void setCode_state(String code_state) {
        this.code_state = code_state;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDate_birthday() {
        return date_birthday;
    }

    public void setDate_birthday(LocalDate date_birthday) {
        this.date_birthday = date_birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getData_issue() {
        return data_issue;
    }

    public void setData_issue(LocalDate data_issue) {
        this.data_issue = data_issue;
    }

    public LocalDate getData_expiry() {
        return data_expiry;
    }

    public void setData_expiry(LocalDate data_expiry) {
        this.data_expiry = data_expiry;
    }

    public String getPlace_birth() {
        return place_birth;
    }

    public void setPlace_birth(String place_birth) {
        this.place_birth = place_birth;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
}
