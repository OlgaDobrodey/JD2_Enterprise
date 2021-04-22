package by.it_academy.jd2.store.core.dto;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vitali Tsvirko
 */
@Entity
@Table(name = "warehouse")
public class Warehouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private int count;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "address_id")
    private WarehouseAddress warehouseAddress;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public WarehouseAddress getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(WarehouseAddress warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }
}
