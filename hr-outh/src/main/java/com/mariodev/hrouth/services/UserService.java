package com.mariodev.hrouth.services;

import com.mariodev.hrouth.entities.User;
import com.mariodev.hrouth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null) {
            throw new IllegalArgumentException("Email not found");
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userFeignClient.findByEmail(userName).getBody();
        if(user == null) {
            throw new IllegalArgumentException("Email not found");
        }
        return user;
    }
}
