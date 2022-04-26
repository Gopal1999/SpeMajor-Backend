package com.example.spemajorbackend.security.controller;


import com.example.spemajorbackend.entity.Admin;
import com.example.spemajorbackend.security.Repository.AdminRepo;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ApiController
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
    private AdminRepo adminRepository;

    @RequestMapping({"/"})
    public String fun()
    {
        return "Hello World!";
    }

    @RequestMapping({"/currentUser"})
    public Optional<Admin> getuser() throws UsernameNotFoundException
    {
        UserDetails userDetails = jwtRequestFilter.getUserDetails();
        String email = userDetails.getUsername();
        Optional<Admin> user = adminRepository.findByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("Not found: " + email));
        return user;
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody Admin authenticateRequest) throws Exception
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