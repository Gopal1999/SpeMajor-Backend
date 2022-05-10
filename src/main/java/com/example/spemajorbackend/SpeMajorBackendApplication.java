package com.example.spemajorbackend;

import com.example.spemajorbackend.repository.ReviewRepo;
import com.example.spemajorbackend.repository.StoragePointRepo;
import com.example.spemajorbackend.security.Repository.VendorRepo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.apache.logging.log4j.LogManager;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {StoragePointRepo.class, ReviewRepo.class, VendorRepo.class})
public class SpeMajorBackendApplication {
    //private static final Logger logger = LoggerFactory.getLogger(SpeMajorBackendApplication.class);

    //private static final Logger logger = LoggerFactory.getLogger(SpeMajorBackendApplication.class);
    public static void main(String[] args) {
        System.out.println("Current Directory = " + System.getProperty("user.dir"));
        SpringApplication.run(SpeMajorBackendApplication.class, args);

        //logger.info("just a test info log");
    }
}
