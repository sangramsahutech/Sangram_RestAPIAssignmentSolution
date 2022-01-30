package com.greatlearningemp.service;

import java.util.List;

import com.greatlearningemp.entity.Employee;
import com.greatlearningemp.entity.Role;
import com.greatlearningemp.entity.User;

public interface EmployeeService {

	Employee saveEmp(Employee employee);
	List<Employee> getEmployees();
	Employee getEmployeeById(Long Id);
	Employee updateEmployee(Long Id, Employee employee);
	Employee deleteEmployee(Long Id);
	List<Employee> getEmployeeByFirstName(String firstName);
	List<Employee> getEmployeesSortByFirstNameAsc();
	List<Employee> getEmployeesSortByFirstNameDesc();
	
	User saveUser(User user);
	Role saveRole(Role role);
}
