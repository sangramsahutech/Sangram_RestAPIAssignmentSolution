package com.greatlearningemp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.greatlearningemp.entity.Employee;
import com.greatlearningemp.entity.Role;
import com.greatlearningemp.entity.User;
import com.greatlearningemp.repository.EmployeeRepository;
import com.greatlearningemp.repository.RoleRepository;
import com.greatlearningemp.repository.UserRepository;
import com.greatlearningemp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	
	PasswordEncoder passwordEncoder;
	
	@Override
	public Employee saveEmp(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long Id) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalEmployee = employeeRepository.findById(Id);
		if(optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Long Id, Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee deleteEmployee(Long Id) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalEmployee = employeeRepository.findById(Id);
		if(optionalEmployee.isPresent()) {
			Employee actualEmployeeToDelete = optionalEmployee.get();
			employeeRepository.delete(actualEmployeeToDelete);
			return actualEmployeeToDelete;
		}
		return null;
	}

	@Override
	public List<Employee> getEmployeeByFirstName(String firstName) {
		// TODO Auto-generated method stub
		List<Employee> empList = employeeRepository.findByFirstNameContainsAllIgnoreCase(firstName);
		return empList;
	}

	@Override
	public List<Employee> getEmployeesSortByFirstNameAsc() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,"firstName"));
	}

	@Override
	public List<Employee> getEmployeesSortByFirstNameDesc() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(Sort.by(Sort.Direction.DESC,"firstName"));
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		this.passwordEncoder =new BCryptPasswordEncoder();
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	
}
