package by.it_academy.jd2.store.core.dto;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Vitali Tsvirko
 */
@Entity
@Table(name = "provider")
public class Provider implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String unp;

    private String address;
    private String bank_account;

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
}
