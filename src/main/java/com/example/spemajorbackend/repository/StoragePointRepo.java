package com.example.spemajorbackend.repository;

import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.entity.nested.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoragePointRepo extends JpaRepository<StoragePoint, Integer>
{
    StoragePoint findById(String id);

    List<StoragePoint> findByVendorId(int id);

    Optional<StoragePoint> findByCoordinates(Coordinates coordinates);
}
