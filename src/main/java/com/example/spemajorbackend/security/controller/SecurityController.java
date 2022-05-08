package com.example.spemajorbackend.security.controller;
import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.entity.Vendor;
import com.example.spemajorbackend.repository.StoragePointRepo;
import com.example.spemajorbackend.security.Repository.VendorRepo;
import com.example.spemajorbackend.security.configurer.MyUserDetailsService;
import com.example.spemajorbackend.security.entity.AuthenticateResponse;
import com.example.spemajorbackend.security.filters.JwtRequestFilter;
import com.example.spemajorbackend.security.util.jwtutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendor")
public class SecurityController
{
    @Autowired
    JwtRequestFilter jwtRequestFilter;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private jwtutil jwtutilToken;

    @Autowired
    StoragePointRepo storagePointRepo;

    @Autowired
    VendorRepo vendorRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String register(@RequestBody Vendor user) {
        System.out.println(user);
        Optional<Vendor> admin = vendorRepository.findByEmail(user.getEmail());
        if (!admin.isEmpty()) {
            return "User already Exists with this Email-id";
        } else {
            vendorRepository.save(user);

            return "Sign Up Successfull";
        }
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping("/id/getall")
    public List<StoragePoint> getAllStoragePoints()
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

    @RequestMapping({"/currentUser"})
    public Optional<Vendor> getuser() throws UsernameNotFoundException
    {
        UserDetails userDetails = jwtRequestFilter.getUserDetails();
        String email = userDetails.getUsername();
        Optional<Vendor> user = vendorRepository.findByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("Not found: " + email));
        return user;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addstoragepoint")
    public String addNewStoragePoint(@RequestBody StoragePoint storagePoint)
    {
        UserDetails userDetails = jwtRequestFilter.getUserDetails();
        String email = userDetails.getUsername();
        Optional<Vendor> user = vendorRepository.findByEmail(email);
        if(user.isEmpty())
        {
            return "You are not an authorised Vendor";
        }
        Optional<StoragePoint> obj = storagePointRepo.findByCoordinates(storagePoint.getCoordinates());
        if(obj.isEmpty()) {
            storagePointRepo.save(storagePoint);
            user.get().getStoragePoint().add(obj.get());
            return "StoragePoint is added";
        }
        else
        {
            return "StoragePoint is already added";
        }
    }

    @PutMapping("/update_storage_point")
    public String updateStoragePoint(@RequestBody StoragePoint storagePoint)
    {
        StoragePoint storedStoragePoint = storagePointRepo.findById(storagePoint.getId());
        storedStoragePoint.setName(storagePoint.getName());
        storedStoragePoint.setPhone(storagePoint.getPhone());
        storedStoragePoint.setPrice(storagePoint.getPrice());
        storagePointRepo.save(storagePoint);
        return "Success";
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Vendor authenticateRequest) throws Exception
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