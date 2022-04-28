package com.example.spemajorbackend;

import com.example.spemajorbackend.repository.ReviewRepo;
import com.example.spemajorbackend.repository.StoragePointRepo;
import com.example.spemajorbackend.security.Repository.VendorRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = {StoragePointRepo.class, ReviewRepo.class, VendorRepo.class})
@SpringBootApplication
public class SpeMajorBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpeMajorBackendApplication.class, args);
    }

}
