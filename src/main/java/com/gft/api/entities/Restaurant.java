package com.gft.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String celNumber;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, String email, String celNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.celNumber = celNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelNumber() {
        return celNumber;
    }

    public void setCelNumber(String celNumber) {
        this.celNumber = Restaurant.this.celNumber;
    }
}
