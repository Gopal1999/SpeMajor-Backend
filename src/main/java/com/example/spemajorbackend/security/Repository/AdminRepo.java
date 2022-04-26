package com.example.spemajorbackend.security.Repository;

import com.example.spemajorbackend.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepo extends JpaRepository<Admin, Integer>
{
    Optional<Admin> findByEmail(String email);
}
