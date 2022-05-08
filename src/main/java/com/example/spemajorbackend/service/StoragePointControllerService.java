package com.example.spemajorbackend.service;

import com.example.spemajorbackend.entity.Region;
import com.example.spemajorbackend.entity.Review;
import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.entity.StoragePointWithRegion;
import com.example.spemajorbackend.entity.nested.Center;
import com.example.spemajorbackend.repository.ReviewRepo;
import com.example.spemajorbackend.repository.StoragePointRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoragePointControllerService
{
    @Autowired
    StoragePointRepo storagePointRepo;

    @Autowired
    ReviewRepo reviewRepo;

    public StoragePointWithRegion getnearBySP(double latitude, double longitude, int radius)
    {
        List<StoragePoint> list = storagePointRepo.findAll();
        List<StoragePoint>result = new ArrayList<>();
        Center center = new Center();
        center.setLatitude(latitude);
        center.setLongitude(longitude);
        Region region = new Region(center);
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

        StoragePointWithRegion storagePointWithRegion = new StoragePointWithRegion();
        storagePointWithRegion.setList(result);
        storagePointWithRegion.setRegion(region);
        return storagePointWithRegion;
    }

    public StoragePoint getSP(int id)
    {
        return storagePointRepo.findByStoragepoint_id(id);
    }

    public List<Review> getallReview(int id)
    {
        return reviewRepo.findReviewByStoragepoint_id(id);
    }
}
