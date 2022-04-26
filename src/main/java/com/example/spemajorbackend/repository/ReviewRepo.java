package com.example.spemajorbackend.repository;

import com.example.spemajorbackend.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, String>
{
    List<Review> findByStoragepointId(String id);
}
