package com.mariodev.hrouth.services;

import com.mariodev.hrouth.entities.User;
import com.mariodev.hrouth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if(user == null) {
            throw new IllegalArgumentException("Email not found");
        }
        return user;
    }
}
