package com.example.spemajorbackend.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Admin
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String role;
    private String mobile;

    public Admin()
    {

    }

    @OneToMany(mappedBy = "admin")
    private List<StoragePoint> storagePoint = new ArrayList<>();

    public Admin(int id, String email, String password, String role, String mobile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<StoragePoint> getStoragePoint() {
        return storagePoint;
    }

    public void setStoragePoint(List<StoragePoint> storagePoint) {
        this.storagePoint = storagePoint;
    }
}
