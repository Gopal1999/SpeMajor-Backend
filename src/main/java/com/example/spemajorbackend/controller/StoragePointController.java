package com.example.spemajorbackend.controller;

import com.example.spemajorbackend.entity.Region;
import com.example.spemajorbackend.entity.Review;
import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.entity.StoragePointWithRegion;
import com.example.spemajorbackend.entity.nested.Center;
import com.example.spemajorbackend.repository.ReviewRepo;
import com.example.spemajorbackend.repository.StoragePointRepo;
import com.example.spemajorbackend.service.StoragePointControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    StoragePointControllerService storagePointControllerService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value = "/getall")
    public StoragePointWithRegion getNearBy(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude, @RequestParam("radius") Integer radius)
    {
        return storagePointControllerService.getnearBySP(latitude, longitude, radius);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping("/{id}")
    public StoragePoint getStoragePoint(@PathVariable Integer id)
    {
        return storagePointControllerService.getSP(id);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping("/{id}/reviews")
    public List<Review> getReviews(@PathVariable Integer id)
    {
        return storagePointControllerService.getallReview(id);
    }
}
