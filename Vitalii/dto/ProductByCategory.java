package by.it_academy.jd2.store.core.dto;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Vitali Tsvirko
 */
@Entity
public class ProductByCategory extends Product implements Serializable {
    @Transient
    @OneToMany
    private Set<Category> categories;

    public Set<Category> getProductsByCategory(Product product) {
        return categories;
    }
}
