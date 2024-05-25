package com.hosiptal.web.repository;

import com.hosiptal.web.models.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupervisorRepository extends JpaRepository<Supervisor,Long> {
    Optional<Supervisor> findByNameAndPassword(String name,String password);
    Supervisor findByName(String name);
}
