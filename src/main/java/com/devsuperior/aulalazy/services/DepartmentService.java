package com.devsuperior.aulalazy.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.aulalazy.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.aulalazy.dto.DepartmentDTO;
import com.devsuperior.aulalazy.dto.EmployeeMinDTO;
import com.devsuperior.aulalazy.entities.Department;
import com.devsuperior.aulalazy.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	@Transactional(readOnly = true)
	public DepartmentDTO findById(Long id) {
		Optional<Department> result = repository.findById(id);
		return new DepartmentDTO(result.get());
	}

	@Transactional(readOnly = true)
	public List<EmployeeMinDTO> findEmployeesByDepartment(Long id) {
		Optional<Department> result = repository.findById(id);
		List<Employee> list = result.get().getEmployees();
		return list.stream().map(x -> new EmployeeMinDTO(x)).toList();
	}
}
