package com.greatlearningemp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearningemp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findByFirstNameContainsAllIgnoreCase(String firstName);
//	List<Employee> findByFirstNameOrderByFirstNameAsc();
//	List<Employee> findByFirstNameOrderByFirstNameDesc();
}
