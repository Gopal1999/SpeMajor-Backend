package com.example.spemajorbackend.security.controller;
import com.example.spemajorbackend.entity.StoragePoint;
import com.example.spemajorbackend.entity.Vendor;
import com.example.spemajorbackend.repository.StoragePointRepo;
import com.example.spemajorbackend.security.Repository.VendorRepo;
import com.example.spemajorbackend.security.configurer.MyUserDetailsService;
import com.example.spemajorbackend.security.entity.AuthenticateResponse;
import com.example.spemajorbackend.security.filters.JwtRequestFilter;
import com.example.spemajorbackend.security.util.jwtutil;
import com.example.spemajorbackend.service.SecurityControllerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
@RequestMapping("/vendor")
public class SecurityController
{
    @Autowired
    SecurityControllerService securityControllerService;

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public String register(@RequestBody Vendor user)
    {
        return securityControllerService.registerVendor(user);
    }

    @RequestMapping("/getall")
    @CrossOrigin(origins = "http://localhost:8100")
    public List<StoragePoint> getAllStoragePoints()
    {
        return securityControllerService.getAllSP();
    }

    @RequestMapping({"/currentUser"})
    public Vendor getuser() throws UsernameNotFoundException
    {
        return securityControllerService.getCurrentUser();
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/addstoragepoint")
//    public String addNewStoragePoint(@RequestBody StoragePoint storagePoint)
//    {
//        UserDetails userDetails = jwtRequestFilter.getUserDetails();
//        String email = userDetails.getUsername();
//        Optional<Vendor> user = vendorRepository.findByEmail(email);
//        if(user.isEmpty())
//        {
//            return "You are not an authorised Vendor";
//        }
//        Optional<StoragePoint> obj = storagePointRepo.findByCoordinates(storagePoint.getCoordinates());
//        if(obj.isEmpty()) {
//            storagePointRepo.save(storagePoint);
//            user.get().getStoragePoint().add(obj.get());
//            return "StoragePoint is added";
//        }
//        else
//        {
//            return "StoragePoint is already added";
//        }
//    }



    @CrossOrigin(origins = "http://localhost:8100")
    @PutMapping("/update_storage_point")
    public String updateStoragePoint(@RequestBody StoragePoint storagePoint)
    {
        return securityControllerService.updateSP(storagePoint);
    }

    @CrossOrigin(origins = "http://localhost:8100")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Vendor authenticateRequest) throws Exception
    {
        return securityControllerService.authenticateVendor(authenticateRequest);
    }
}
