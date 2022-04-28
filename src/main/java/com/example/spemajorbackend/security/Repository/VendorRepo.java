package com.example.spemajorbackend.security.Repository;

import com.example.spemajorbackend.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepo extends JpaRepository<Vendor, Integer>
{
    Optional<Vendor> findByEmail(String email);
}
