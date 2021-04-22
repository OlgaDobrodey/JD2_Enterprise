package by.it_academy.jd2.core.dto.store;

import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "warehouse", schema = "store")
public class Warehouse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer count;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "adress_id")
    private WarehouseAddress warehouse_address;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    public Warehouse() {
    }

    public Warehouse(Integer id, Integer count, @NotNull WarehouseAddress warehouse_address, @NotNull Product product, @NotNull Provider provider) {
        this.id = id;
        this.count = count;
        this.warehouse_address = warehouse_address;
        this.product = product;
        this.provider = provider;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public WarehouseAddress getWarehouse_address() {
        return warehouse_address;
    }

    public void setWarehouse_address(WarehouseAddress warehouse_address) {
        this.warehouse_address = warehouse_address;
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

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", count=" + count +
                ", warehouse_address=" + warehouse_address +
                ", product=" + product +
                ", provider=" + provider +
                '}';
    }
}
