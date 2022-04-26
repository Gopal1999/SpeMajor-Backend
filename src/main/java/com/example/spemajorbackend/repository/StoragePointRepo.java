package com.example.spemajorbackend.repository;

import com.example.spemajorbackend.entity.StoragePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoragePointRepo extends JpaRepository<StoragePoint, Integer>
{
    StoragePoint findById(String id);
}
