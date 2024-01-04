package com.loxasoft.departamentservice.repository;

import com.loxasoft.departamentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
