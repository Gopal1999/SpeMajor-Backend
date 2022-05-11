package com.example.spemajorbackend.controller;

import com.example.spemajorbackend.SpeMajorBackendApplication;
import com.example.spemajorbackend.entity.Region;
import com.example.spemajorbackend.entity.Review;
import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.entity.StoragePointWithRegion;
import com.example.spemajorbackend.entity.nested.Center;
import com.example.spemajorbackend.repository.ReviewRepo;
import com.example.spemajorbackend.repository.StoragePointRepo;
import com.example.spemajorbackend.service.StoragePointControllerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/storagepoint")
public class StoragePointController
{
    private static final Logger logger = LogManager.getLogger(SpeMajorBackendApplication.class);
    @Autowired
    StoragePointRepo storagePointRepo;

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    StoragePointControllerService storagePointControllerService;


    @CrossOrigin(origins = "http://172.30.0.4:8100")
    @RequestMapping(value = "/getall")
    public StoragePointWithRegion getNearBy(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude, @RequestParam("radius") Integer radius)
    {
        logger.info("Get Nearby is called");
        return storagePointControllerService.getnearBySP(latitude, longitude, radius);

    }

    //@CrossOrigin(origins = "http://localhost:8100")
    @CrossOrigin(origins = "http://172.30.0.4:8100")
    @RequestMapping("/{id}")
    public StoragePoint getStoragePoint(@PathVariable Integer id)
    {
        logger.info("getStoragePoint is called");
        return storagePointControllerService.getSP(id);
    }

    //@CrossOrigin(origins = "http://localhost:8100")
    @CrossOrigin(origins = "http://172.30.0.4:8100")
    @RequestMapping("/{id}/reviews")
    public List<Review> getReviews(@PathVariable Integer id)
    {
        logger.info("getReviews is called");
        return storagePointControllerService.getallReview(id);
    }
}
