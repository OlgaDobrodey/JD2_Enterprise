package by.it_academy.jd2.store.core.dto;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Vitali Tsvirko
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "manufacture_id")
    private Manufacture manufacture;

    @NotNull
    private double cost;

    @NotNull
    private double rating;

    @NotNull
    private String characteristics;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }
}
