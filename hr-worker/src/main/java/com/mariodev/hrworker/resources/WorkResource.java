package com.mariodev.hrworker.resources;


import com.mariodev.hrworker.entities.Worker;
import com.mariodev.hrworker.repositories.WorkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkResource {
    private static Logger logger = LoggerFactory.getLogger(WorkResource.class);

    @Autowired
    private WorkRepository workRepository;
    @Autowired
    private Environment env;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workRepository.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("Port= " + env.getProperty("local.server.port"));

        Worker obj = workRepository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
