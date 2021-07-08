package by.it_academy.jd2.core.model;


import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;


@Entity(name = "Passport")
@Table(name = "passport", schema = "polyclinic")
public class Passport {

    @Id
    @Generated(GenerationTime.NEVER)
    @Column(name = "id_passport")
    private String id_passport;
    @Column(name = "identification")
    private String identification;
    @Column(name = "code_state")
    private String code_state;
    @Column(name = "nationality;")
    private String nationality;
    @Column(name = "date_birthday")
    private Date date_birthday;
    @Column(name = "sex")
    private String sex;
    @Column(name = "data_issue")
    private Date data_issue;
    @Column(name = "data_expiry")
    private Date data_expiry;
    @Column(name = "place_birth")
    private String place_birth;

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

    public Date getDate_birthday() {
        return date_birthday;
    }

    public void setDate_birthday(Date date_birthday) {
        this.date_birthday = date_birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getData_issue() {
        return data_issue;
    }

    public void setData_issue(Date data_issue) {
        this.data_issue = data_issue;
    }

    public Date getData_expiry() {
        return data_expiry;
    }

    public void setData_expiry(Date data_expiry) {
        this.data_expiry = data_expiry;
    }

    public String getPlace_birth() {
        return place_birth;
    }

    public void setPlace_birth(String place_birth) {
        this.place_birth = place_birth;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id_passport='" + id_passport + '\'' +
                ", identification='" + identification + '\'' +
                ", code_state='" + code_state + '\'' +
                ", nationality='" + nationality + '\'' +
                ", date_birthday=" + date_birthday +
                ", sex='" + sex + '\'' +
                ", data_issue=" + data_issue +
                ", data_expiry=" + data_expiry +
                ", place_birth='" + place_birth + '\'' +
                '}';
    }
}
