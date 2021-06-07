package com.devsuperior.aulalazy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.aulalazy.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
