package com.example.spemajorbackend.security.filters;
import com.example.spemajorbackend.security.configurer.MyUserDetailsService;
import com.example.spemajorbackend.security.util.jwtutil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private UserDetails userDetails;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private jwtutil jutil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String jwt = null;
        if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer "))
        {
            jwt = authorizationHeader.substring(7);
            username = jutil.extractUsername(jwt);
            if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
            {
                userDetails = this.myUserDetailsService.loadUserByUsername(username);
                if(jutil.validateToken(jwt, userDetails))
                {
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        filterChain.doFilter(request,response);
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

}
