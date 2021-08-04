package by.it_academy.jd2.core.model.people;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "passports", schema = "polyclinic")
public class Passport {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "id_passport")
    private String idPassport;
    private String identification;
    private String code_state;
    private String nationality;
    private LocalDate date_birthday;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private LocalDate data_issue;
    private LocalDate data_expiry;
    private String place_birth;

    @OneToOne
    @JoinColumn(name = "login_user")
    private User users;

    public Passport() {
    }

    public Passport(String idPassport, String identification, String code_state, String nationality, LocalDate date_birthday, Sex sex, LocalDate data_issue, LocalDate data_expiry, String place_birth, User users) {
        this.idPassport = idPassport;
        this.identification = identification;
        this.code_state = code_state;
        this.nationality = nationality;
        this.date_birthday = date_birthday;
        this.sex = sex;
        this.data_issue = data_issue;
        this.data_expiry = data_expiry;
        this.place_birth = place_birth;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getId_passport() {
        return idPassport;
    }

    public void setId_passport(String id_passport) {
        this.idPassport = id_passport;
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
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


    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", idPassport='" + idPassport + '\'' +
                ", identification='" + identification + '\'' +
                ", code_state='" + code_state + '\'' +
                ", nationality='" + nationality + '\'' +
                ", date_birthday=" + date_birthday +
                ", sex=" + sex +
                ", data_issue=" + data_issue +
                ", data_expiry=" + data_expiry +
                ", place_birth='" + place_birth + '\'' +
                ", users=" + users +
                '}';
    }
}
