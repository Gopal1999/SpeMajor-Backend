package com.example.spemajorbackend.entity;

import com.example.spemajorbackend.entity.nested.Coordinates;
import com.example.spemajorbackend.entity.nested.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StoragePoint
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int storagepoint_id;

    @Column(nullable = false)
    private String id;

    private String alias;
    private String name;
    private String image_url;
    private boolean is_closed;
    private float rating;

    @Embedded
    private Coordinates coordinates;

    private String price;

    @Embedded
    private Location location;


    private String phone;
    private String display_phone;
    private double distance;

    @OneToMany(mappedBy = "storagepoint")
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy = "storagepoint")
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private Vendor vendor;

    public StoragePoint()
    {

    }

    public StoragePoint(String id, String alias, String name, String image_url, boolean is_closed, float rating, Coordinates coordinates, String price, Location location, String phone, String display_phone, double distance) {
        this.id = id;
        this.alias = alias;
        this.name = name;
        this.image_url = image_url;
        this.is_closed = is_closed;
        this.rating = rating;
        this.coordinates = coordinates;
        this.price = price;
        this.location = location;
        this.phone = phone;
        this.display_phone = display_phone;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisplay_phone() {
        return display_phone;
    }

    public void setDisplay_phone(String display_phone) {
        this.display_phone = display_phone;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public int getStoragepoint_id() {
        return storagepoint_id;
    }

    public void setStoragepoint_id(int storagepoint_id) {
        this.storagepoint_id = storagepoint_id;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
