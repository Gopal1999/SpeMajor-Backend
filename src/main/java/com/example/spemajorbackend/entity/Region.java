package com.example.spemajorbackend.entity;

import com.example.spemajorbackend.entity.nested.Center;

import javax.persistence.*;

@Entity
public class Region
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Center center;

    public Region()
    {

    }

    public Region(Center center) {
        this.center = center;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }
}
