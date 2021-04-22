package by.it_academy.jd2.core.dto.store;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//@Entity
@Table(name = "product", schema = "store")
public class ProductWithConstrains extends Product implements Serializable {


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cross_category_product",schema = "store",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    private Set<CategoreWithConstrains> categores = new HashSet<>();

     public ProductWithConstrains() {
    }

//    public void setCategores(Set<CategoreWithConstrains> categores) {
//        this.categores = categores;
//    }

    public Set<CategoreWithConstrains> getCategores() {
        return categores;
    }



  }

