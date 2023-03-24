package com.example.hruser.resources;

import com.example.hruser.entities.User;
import com.example.hruser.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    private static Logger logger = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Environment env;


    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = userRepository.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        logger.info("Port= " + env.getProperty("local.server.port"));

        User obj = userRepository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        logger.info("Port= " + env.getProperty("local.server.port"));

        User obj = userRepository.findByEmail(email);
        return ResponseEntity.ok(obj);
    }
}
