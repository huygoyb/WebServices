package com.example.crudapi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "userss", schema = "dbo", catalog = "Springboot1Users") ->Springboot1_users
@Table(name = "userss")
public class UserssEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private String price;
    @Basic
    @Column(name = "quantity")
    private String quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getprice() {
        return price;
    }

    public void setprice(String price) {
        this.price = price;
    }

    public String getquantity() {
        return quantity;
    }

    public void setquantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserssEntity that = (UserssEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, quantity);
    }
}
