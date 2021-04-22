package by.it_academy.jd2.store.core.dto;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vitali Tsvirko
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;


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
}
