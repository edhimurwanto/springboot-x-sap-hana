package com.test.hanadbb.entities;

import java.util.*;
import jakarta.persistence.*;

@Table
@Entity
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT e FROM Students e")
})
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    public Date cratedAt;

    @PrePersist
    public void onCreate(){
        this.cratedAt = new Date();
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    public Date updatedAt;

    @PreUpdate
    public void onUpdate(){
        this.updatedAt = new Date();
    }

}


