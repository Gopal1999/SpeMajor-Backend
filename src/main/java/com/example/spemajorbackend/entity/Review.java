package com.example.spemajorbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int review_id;

    private String id;

    private int rating;
    private String text;
    private String time_created;

    @OneToOne
    private ServiceConsumer user;

    @ManyToOne @JsonIgnore
    private StoragePoint storagepoint;


    public Review()
    {

    }

    public Review(String id, int rating, String text, String time_created) {
        this.id = id;
        this.rating = rating;
        this.text = text;
        this.time_created = time_created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime_created() {
        return time_created;
    }

    public void setTime_created(String time_created) {
        this.time_created = time_created;
    }

    public ServiceConsumer getUser() {
        return user;
    }

    public void setUser(ServiceConsumer user) {
        this.user = user;
    }

    public StoragePoint getStoragepoint() {
        return storagepoint;
    }

    public void setStoragepoint(StoragePoint storagepoint) {
        this.storagepoint = storagepoint;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }
}
