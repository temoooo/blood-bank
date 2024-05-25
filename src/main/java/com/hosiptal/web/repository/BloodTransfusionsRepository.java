package com.hosiptal.web.repository;

import com.hosiptal.web.models.BloodTransfusions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodTransfusionsRepository extends JpaRepository<BloodTransfusions , Long> {
    List<BloodTransfusions> findByEmployeeId(Long id);
}
