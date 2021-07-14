package by.it_academy.jd2.core.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "medical_card", schema = "polyclinic")
public class MedicalCard {
    /**
     * CREATE TABLE polyclinic.medical_card
     * (
     * id bigint NOT NULL,
     * doctor character varying(10) COLLATE pg_catalog."default",
     * patient character varying(10) COLLATE pg_catalog."default",
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "doctor")
    private User doctor;


    @OneToOne
    @JoinColumn(name = "patient")
    private User patient;

    private String diagnosis;


    public MedicalCard() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(User patient) {
        this.patient = patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "MedicalCard{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", diagnosis=" + diagnosis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalCard that = (MedicalCard) o;
        return id.equals(that.id) && doctor.equals(that.doctor) && patient.equals(that.patient) && diagnosis.equals(that.diagnosis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, doctor, patient, diagnosis);
    }
}
