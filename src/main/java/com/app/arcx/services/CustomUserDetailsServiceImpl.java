package com.app.arcx.services;

import com.app.arcx.domain.User;
import com.app.arcx.dto.CustomUserDetails;
import com.app.arcx.repository.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = null;
        if (s.contains("@"))
        {
            user = userRepository.findByEmail(s).orElseThrow(() -> new UsernameNotFoundException("User not found with email " + s));
        }
        else {
            user = userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("User not found with username " + s));
        }
        return new CustomUserDetails(user);
    }
}
