package by.it_academy.jd2.store.core.dto;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vitali Tsvirko
 */
@Entity
@Table(name = "manufacture")
public class Manufacture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
