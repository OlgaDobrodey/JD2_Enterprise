package by.it_academy.jd2.core.dto.store;

import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//@Entity
@Table(name = "category", schema = "store")
public class CategoreWithConstrains extends Category implements Serializable {


    @ManyToMany(mappedBy = "categores")
    private Set<ProductWithConstrains> products = new HashSet<>();

    public CategoreWithConstrains() {
    }

    public Set<ProductWithConstrains> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductWithConstrains> products) {
        this.products = products;
    }
}
