package com.example.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    // Relation future avec Order
    // @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    // private Set<Order> orders = new HashSet<>();

    // Constructeur vide obligatoire
    public Client() {
    }

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters / Setters

    public Long getId() {
        return id;
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

    // public Set<Order> getOrders() {
    // return orders;
    // }

    // public void setOrders(Set<Order> orders) {
    // this.orders = orders;
    // }
}
