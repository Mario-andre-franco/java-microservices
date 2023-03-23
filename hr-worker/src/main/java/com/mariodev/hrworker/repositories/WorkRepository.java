package com.mariodev.hrworker.repositories;

import com.mariodev.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Worker,Long> {
}
