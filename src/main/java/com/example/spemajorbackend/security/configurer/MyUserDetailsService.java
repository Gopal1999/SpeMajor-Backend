package com.example.spemajorbackend.security.configurer;

import com.example.spemajorbackend.entity.Vendor;
import com.example.spemajorbackend.security.Repository.VendorRepo;
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
    VendorRepo adminRepository;

    //    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new MyUserDetails(username);
//    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        Optional<Vendor> user = adminRepository.findByEmail(email);

        user.orElseThrow(()->new UsernameNotFoundException("Not found: " + email));
        return user.map(MyUserDbDetails::new).get();
    }
}
