package com.example.spemajorbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Photo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int photo_id;

    private String id;

    @ManyToOne @JsonIgnore
    private StoragePoint storagepoint;

    public Photo() {

    }

    public Photo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StoragePoint getStoragepoint() {
        return storagepoint;
    }

    public void setStoragepoint(StoragePoint storagepoint) {
        this.storagepoint = storagepoint;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }
}
