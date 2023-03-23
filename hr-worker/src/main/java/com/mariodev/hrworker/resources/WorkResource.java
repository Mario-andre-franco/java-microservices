package com.mariodev.hrworker.resources;


import com.mariodev.hrworker.entities.Worker;
import com.mariodev.hrworker.repositories.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkResource {

    @Autowired
    private WorkRepository workRepository;


    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workRepository.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        Worker obj = workRepository.findById(id).get();
        return ResponseEntity.ok(obj);
    }
}
