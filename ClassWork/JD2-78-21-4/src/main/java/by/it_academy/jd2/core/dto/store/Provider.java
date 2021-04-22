package by.it_academy.jd2.core.dto.store;

import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "provider", schema = "store")
public class Provider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer provider_id;
    @NotNull
    private String name;
    @NotNull
    private String unp;
    private String address;
    private String bank_account;

    public Provider() {

    }

    public Provider(Integer provider_id, String name, String unp, String address, String bank_account) {
        this.provider_id = provider_id;
        this.name = name;
        this.unp = unp;
        this.address = address;
        this.bank_account = bank_account;
    }

    public Integer getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(Integer provider_id) {
        this.provider_id = provider_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnp() {
        return unp;
    }

    public void setUnp(String unp) {
        this.unp = unp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "provider_id=" + provider_id +
                ", name='" + name + '\'' +
                ", unp='" + unp + '\'' +
                ", address='" + address + '\'' +
                ", bank_account='" + bank_account + '\'' +
                '}';
    }
}
