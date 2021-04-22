package by.it_academy.jd2.core.dto.store;

import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product", schema = "store")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer product_id;

    @NotNull
    private String name;
    @NotNull
    private Double cost;
    @NotNull
    private Double rating;
    @NotNull
    private String characteristics;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "manufacture_id")
    private Manufacture manufacture;

    public Product() {
    }

    public Product(Integer id, @NotNull String name, @NotNull Double cost, @NotNull Double rating, @NotNull String characteristics, @NotNull Manufacture manufacture) {
        this.product_id = id;
        this.name = name;
        this.cost = cost;
        this.rating = rating;
        this.characteristics = characteristics;
        this.manufacture = manufacture;
    }

    @ManyToMany
    @JoinTable(
            name = "cross_category_product", schema = "store",
            joinColumns = {@JoinColumn(name = "id_product")},
            inverseJoinColumns = {@JoinColumn(name = "id_category")}
    )
    private Set<Category> categores = new HashSet<>();

    public Integer getId() {
        return product_id;
    }

    public void setId(Integer id) {
        this.product_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public void setCategores(Set<Category> categores) {
        this.categores = categores;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + product_id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", rating=" + rating +
                ", characteristics='" + characteristics + '\'' +
                ", manufacture=" + manufacture +
                '}';
    }
}
