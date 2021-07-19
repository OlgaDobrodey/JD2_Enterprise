package by.it_academy.jd2.core.model.medical;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "diagnosis", schema = "polyclinic")
public class Diagnosis implements Comparable<Diagnosis>{
    /**
     * CREATE TABLE polyclinic.diagnosis
     * (
     * id integer NOT NULL,
     * medical_catd integer,
     * diagnosis text COLLATE pg_catalog."default",
     * prescription text COLLATE pg_catalog."default",
     * date timestamp without time zone,
     * status character varying(7) COLLATE pg_catalog."default",
     * CONSTRAINT diagnosis_pkey PRIMARY KEY (id),
     * CONSTRAINT diagnosis FOREIGN KEY (medical_catd)
     * REFERENCES polyclinic.medical_card (id) MATCH SIMPLE
     * ON UPDATE NO ACTION
     * ON DELETE NO ACTION
     * NOT VALID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "card")
    private MedicalCard card;
    private String prescription;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Diagnosis() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MedicalCard getCard() {
        return card;
    }

    public void setMedical_card(MedicalCard card) {
        this.card = card;
    }


    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", medical_card=" + card +

                ", prescription='" + prescription + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnosis diagnosis1 = (Diagnosis) o;
        return Objects.equals(id, diagnosis1.id) && Objects.equals(card, diagnosis1.card) && Objects.equals(prescription, diagnosis1.prescription) && Objects.equals(date, diagnosis1.date) && status == diagnosis1.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, card,  prescription, date, status);
    }

    @Override
    public int compareTo(Diagnosis o) {
        if (this.getDate().isAfter(o.getDate())) {
            return 1;
        } else if (this.getDate().isBefore(o.getDate())) {
            return -1;
        }
        return 0;
    }

}
