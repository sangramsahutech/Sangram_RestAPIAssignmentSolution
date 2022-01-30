package com.greatlearningemp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearningemp.entity.Employee;
import com.greatlearningemp.entity.Role;
import com.greatlearningemp.entity.User;
import com.greatlearningemp.service.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees/get")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@PostMapping("/employees/load")
	public Employee saveEmp(@RequestBody Employee employee) {
		return employeeService.saveEmp(employee);
	}
	
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable("id") Long empId) {
		return employeeService.getEmployeeById(empId);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable("id") Long empId, @RequestBody Employee employeeObject) {
		return employeeService.updateEmployee(empId, employeeObject);
	}
	
	@DeleteMapping("/employees/{id}")
	public Employee deleteEmployee(@PathVariable("id") Long empId) {
		return employeeService.deleteEmployee(empId);
	}
	
	@GetMapping("/employees/search/{firstName}")
	public List<Employee> getEmployeesByFirstName(@PathVariable("firstName") String first_Name){
		return employeeService.getEmployeeByFirstName(first_Name);
	}
	
	@GetMapping("/employees/sort")
	public List<Employee> getEmployeesSortByFirstNameAsc(@RequestParam String Order){
		String order1 = Order.substring(1,4);
		if(order1.equals("asc")) {
			return employeeService.getEmployeesSortByFirstNameAsc();
		} 
		else if(order1.equals("des")) {
			return employeeService.getEmployeesSortByFirstNameDesc();
		}
		else {
			return employeeService.getEmployeesSortByFirstNameAsc();
		}
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		
		return employeeService.saveUser(user);
	}
	@PostMapping("/roles")
	public Role saveRole(@RequestBody Role role) {
		return employeeService.saveRole(role);
	}
}
