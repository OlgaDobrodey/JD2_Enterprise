package by.it_academy.jd2.core.dto.store;

import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "warehouse_address", schema = "store")
public class WarehouseAddress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "PK")
    private Integer adress_id;
    @NotNull
    private String name;
    @NotNull
    private String address;

    public WarehouseAddress() {
    }

    public WarehouseAddress(Integer adress_id, String name, String address) {
        this.adress_id = adress_id;
        this.name = name;
        this.address = address;
    }

    public Integer getAdress_id() {
        return adress_id;
    }

    public void setAdress_id(Integer adress_id) {
        this.adress_id = adress_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "WarehouseAddress{" +
                "adress_id=" + adress_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
