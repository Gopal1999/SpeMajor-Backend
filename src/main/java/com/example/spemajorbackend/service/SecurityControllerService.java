package com.example.spemajorbackend.service;

import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.entity.Vendor;
import com.example.spemajorbackend.repository.StoragePointRepo;
import com.example.spemajorbackend.security.Repository.VendorRepo;
import com.example.spemajorbackend.security.configurer.MyUserDetailsService;
import com.example.spemajorbackend.security.entity.AuthenticateResponse;
import com.example.spemajorbackend.security.filters.JwtRequestFilter;
import com.example.spemajorbackend.security.util.jwtutil;
import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SecurityControllerService
{
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private jwtutil jwtutilToken;

    @Autowired
    VendorRepo vendorRepository;

    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Autowired
    StoragePointRepo storagePointRepo;

    public String registerVendor(Vendor vendor)
    {
        Optional<Vendor> admin = vendorRepository.findByEmail(vendor.getEmail());
        if (!admin.isEmpty()) {
            return "User already Exists with this Email-id";
        } else {
            vendorRepository.save(vendor);

            return "Sign Up Successfull";
        }
    }

    public List<StoragePoint> getAllSP()
    {
        UserDetails userDetails = jwtRequestFilter.getUserDetails();
        String email = userDetails.getUsername();
        Optional<Vendor> user = vendorRepository.findByEmail(email);
        //user.orElseThrow(()->new UsernameNotFoundException("Not found: " + username));
        if(user.isEmpty())
        {
            return new ArrayList<>();
        }
        List<StoragePoint> list =  storagePointRepo.findByVendorId(user.get().getId());
        List<StoragePoint> result = new ArrayList<>();
        for(StoragePoint storagePoint: list)
        {
            storagePoint.setPhone(user.get().getMobile());
            storagePoint.setDisplay_phone("+91-" + user.get().getMobile());
            result.add(storagePoint);
        }
        return result;
    }

    public Vendor getCurrentUser()
    {
        UserDetails userDetails = jwtRequestFilter.getUserDetails();
        String email = userDetails.getUsername();
        Optional<Vendor> user = vendorRepository.findByEmail(email);
        return user.get();
    }

    public String updateSP(StoragePoint storagePoint)
    {
        StoragePoint storedStoragePoint = storagePointRepo.findByStoragepoint_id(storagePoint.getStoragepoint_id());
        storedStoragePoint.setName(storagePoint.getName());
        storedStoragePoint.setPhone(storagePoint.getPhone());
        storedStoragePoint.setPrice(storagePoint.getPrice());
        storagePointRepo.save(storedStoragePoint);
        System.out.println(storedStoragePoint);
        return "Success";
    }

    public ResponseEntity<?> authenticateVendor(Vendor authenticateRequest) throws Exception
    {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getEmail(), authenticateRequest.getPassword()));
        }catch(BadCredentialsException e)
        {
            throw new Exception("Incorrect Username or password", e);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticateRequest.getEmail());
        final String jwt = jwtutilToken.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticateResponse(jwt));
    }
}
