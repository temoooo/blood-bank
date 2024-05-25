package com.hosiptal.web.repository;

import com.hosiptal.web.models.Diseases;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseasesRepository extends JpaRepository<Diseases,Long> {
    List<Diseases> findByDownerId(Long id);
}
