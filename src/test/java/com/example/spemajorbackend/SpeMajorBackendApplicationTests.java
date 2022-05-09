package com.example.spemajorbackend;

import com.example.spemajorbackend.controller.StoragePointController;
import com.example.spemajorbackend.entity.Review;
import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.entity.StoragePointWithRegion;
import com.example.spemajorbackend.entity.Vendor;
import com.example.spemajorbackend.repository.ReviewRepo;
import com.example.spemajorbackend.repository.StoragePointRepo;
import com.example.spemajorbackend.security.Repository.VendorRepo;
import com.example.spemajorbackend.security.controller.SecurityController;
import com.example.spemajorbackend.service.SecurityControllerService;
import com.example.spemajorbackend.service.StoragePointControllerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
class SpeMajorBackendApplicationTests
{


    @Autowired
    StoragePointRepo storagePointRepo;

    @Autowired
    ReviewRepo reviewRepo;

    @Autowired
    VendorRepo vendorRepo;

    @Autowired
    StoragePointControllerService storagePointControllerService;

    @Autowired
    SecurityControllerService securityControllerService;

    @Test
    public void testSingleStoragePoint()
    {
        StoragePoint storagePoint = storagePointRepo.findByStoragepoint_id(2);
        assertEquals("Mishra's Residence", storagePoint.getName());
        assertEquals("250", storagePoint.getPrice());
        assertEquals("8433136231", storagePoint.getPhone());
        assertEquals("RMV8+44P", storagePoint.getLocation().getAddress1());
        assertEquals("Electronics City Phase 1, Electronic City", storagePoint.getLocation().getAddress2());
        assertEquals("Bengaluru", storagePoint.getLocation().getCity());
        assertEquals("India", storagePoint.getLocation().getCountry());
    }

    @Test
    public void testStoragePointReviews()
    {
        List<Review> reviews = reviewRepo.findReviewByStoragepoint_id(1);
        assertThat(reviews.size()).isEqualTo(2);
        assertEquals("Site manager was really friendly and helpful.  Can't thank him enough for his help and support", reviews.get(0).getText());
        assertEquals(4, reviews.get(0).getRating());
        assertEquals("Very helpful receivng my moving boxes from the States. Clean facility. Would use them again.", reviews.get(1).getText());
        assertEquals(5, reviews.get(1).getRating());
    }

    @Test
    public void testGeofencingApi()
    {
        double latitude = 12.84488;
        double longitude = 77.66338;
        int radius = 290;
        StoragePointWithRegion storagePointWithRegion = storagePointControllerService.getnearBySP(latitude, longitude, radius);
        List<StoragePoint> storagePoints = storagePointWithRegion.getList();
        assertThat(storagePoints.size()).isEqualTo(2);
        assertEquals(274.9595017905576, storagePoints.get(0).getDistance(), 0.000);
        assertEquals(211.86282678163764, storagePoints.get(1).getDistance(), 0.000);
    }

    @Test
    public void testRegisterVendor()
    {
        Vendor vendor = new Vendor();
        vendor.setEmail("test6@gmail.com");
        vendor.setPassword("password");
        vendor.setMobile("1234321234");
        vendor.setRole("ADMIN");
        assertEquals("Sign Up Successfull", securityControllerService.registerVendor(vendor));
        assertNotNull(vendorRepo.findByEmail("test6@gmail.com").get());
    }

    @Test
    public void testVendorStoragePoints()
    {
        assertEquals(2, storagePointRepo.findByVendorId(1).size());
    }



}
