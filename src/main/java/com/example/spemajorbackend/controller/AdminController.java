package com.example.spemajorbackend.controller;

import com.example.spemajorbackend.entity.Admin;
import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.repository.StoragePointRepo;
import com.example.spemajorbackend.security.Repository.AdminRepo;
import com.example.spemajorbackend.security.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    JwtRequestFilter jwtRequestFilter;


    @Autowired
    StoragePointRepo storagePointRepo;

    @Autowired
    AdminRepo adminRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String register(@RequestBody Admin user) {
        System.out.println(user);
        Optional<Admin> admin = adminRepository.findByEmail(user.getEmail());
        if (!admin.isEmpty()) {
            return "User already Exists with this Email-id";
        } else {
            adminRepository.save(user);

            return "Sign Up Successfull";
        }
    }

    @RequestMapping("/{id}/getall")
    public List<StoragePoint> getAllStoragePoints(@PathVariable Integer id)
    {
        UserDetails userDetails = jwtRequestFilter.getUserDetails();
        String email = userDetails.getUsername();
        Optional<Admin> user = adminRepository.findByEmail(email);
        //user.orElseThrow(()->new UsernameNotFoundException("Not found: " + username));
        if(user.isEmpty())
        {
            return new ArrayList<>();
        }
        return storagePointRepo.findByAdmin_Id(id);
    }


}
