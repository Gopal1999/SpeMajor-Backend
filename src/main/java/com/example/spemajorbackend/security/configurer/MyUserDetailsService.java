package com.example.spemajorbackend.security.configurer;

import com.example.spemajorbackend.entity.Admin;
import com.example.spemajorbackend.security.Repository.AdminRepo;
import com.example.spemajorbackend.security.entity.MyUserDbDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    AdminRepo adminRepository;

    //    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new MyUserDetails(username);
//    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        Optional<Admin> user = adminRepository.findByEmail(email);

        user.orElseThrow(()->new UsernameNotFoundException("Not found: " + email));
        return user.map(MyUserDbDetails::new).get();
    }
}
