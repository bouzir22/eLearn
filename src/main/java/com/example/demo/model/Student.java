package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
   @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
    private String name;
    private String username;
    private String password;
    @OneToMany(mappedBy = "student")
    private List<Subscription>subscriptions;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
}
