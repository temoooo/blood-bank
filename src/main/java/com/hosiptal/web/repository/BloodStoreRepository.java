package com.hosiptal.web.repository;

import com.hosiptal.web.models.BloodStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodStoreRepository extends JpaRepository<BloodStore , Long> {
    List<BloodStore> findBySupervisorId(Long id);
    BloodStore findBySupervisorIdAndBloodType(Long id,String type);
}
