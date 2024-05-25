package com.hosiptal.web.repository;

import com.hosiptal.web.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {
    List<Employee> findBySupervisorId(Long id);
    Employee findByNameAndPassword(String name , String password);
}
