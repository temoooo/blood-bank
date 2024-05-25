package com.hosiptal.web.repository;

import com.hosiptal.web.models.Downer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DownerRepository extends JpaRepository<Downer,Long> {
    List<Downer> findByEmployeeId(Long id);
}
