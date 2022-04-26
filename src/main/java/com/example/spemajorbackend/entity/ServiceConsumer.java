package com.example.spemajorbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ServiceConsumer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceconsumer_id;

    private String id;

    private String image_url;

    private String name;

    @OneToOne(mappedBy = "user")@JsonIgnore
    private Review review;

    public ServiceConsumer()
    {

    }

    public ServiceConsumer(String id, String image_url, String name) {
        this.id = id;
        this.image_url = image_url;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
