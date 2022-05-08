package com.example.spemajorbackend.repository;

import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.entity.nested.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StoragePointRepo extends JpaRepository<StoragePoint, Integer>
{

    @Query(value = "Select * from StoragePoint where storagepoint_id = ?1", nativeQuery = true)
    StoragePoint findByStoragepoint_id(int id);

    List<StoragePoint> findByVendorId(int id);

    Optional<StoragePoint> findByCoordinates(Coordinates coordinates);
}
