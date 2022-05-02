package com.example.spemajorbackend;

import com.example.spemajorbackend.repository.ReviewRepo;
import com.example.spemajorbackend.repository.StoragePointRepo;
import com.example.spemajorbackend.security.Repository.VendorRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableJpaRepositories(basePackageClasses = {StoragePointRepo.class, ReviewRepo.class, VendorRepo.class})

public class SpeMajorBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpeMajorBackendApplication.class, args);
    }

}
