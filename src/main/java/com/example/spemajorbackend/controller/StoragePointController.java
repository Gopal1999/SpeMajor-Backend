package com.example.spemajorbackend.controller;

import com.example.spemajorbackend.entity.Review;
import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.repository.ReviewRepo;
import com.example.spemajorbackend.repository.StoragePointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/storagepoint")
public class StoragePointController
{
    @Autowired
    StoragePointRepo storagePointRepo;

    @Autowired
    ReviewRepo reviewRepo;

    @RequestMapping(value = "/getall")
    public List<StoragePoint> getNearBy(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude, @RequestParam("radius") Integer radius)
    {
        System.out.println("Hello");
        List<StoragePoint> list = storagePointRepo.findAll();
        List<StoragePoint>result = new ArrayList<>();
        for(StoragePoint obj: list)
        {
            final int R = 6371; // Radius of the earth

            double latDistance = Math.toRadians(latitude - obj.getCoordinates().getLatitude());
            double lonDistance = Math.toRadians(longitude - obj.getCoordinates().getLongitude());
            double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                    + Math.cos(Math.toRadians(latitude)) * Math.cos(Math.toRadians(obj.getCoordinates().getLatitude()))
                    * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = R * c * 1000; // convert to meters

            if(distance<=radius) {
                obj.setDistance(distance);
                result.add(obj);
            }

        }
        return result;
    }

    @RequestMapping("/{id}")
    public StoragePoint getStoragePoint(@PathVariable String id)
    {
        return storagePointRepo.findById(id);
    }

    @RequestMapping("/{id}/reviews")
    public List<Review> getReviews(@PathVariable String id)
    {
        return reviewRepo.findByStoragepointId(id);
    }
}
