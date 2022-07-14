package com.accolite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accolite.model.Employee;
import com.accolite.model.Response;
import com.accolite.repository.EmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	public EmployeeRepository employeeRepo;
	
	public ResponseEntity<Response> addemployee(Employee employee) {
		try {
		 long id=employee.getEmployeeId();
		 Employee e=employeeRepo.findById(id).get();
		 //System.out.println(e);
	     return new ResponseEntity<>(new Response("Employee already exists"),HttpStatus.BAD_REQUEST);
		 }catch(Exception e) {
         employeeRepo.save(employee);
         return new ResponseEntity<>(new Response("Employee added successfully"),HttpStatus.OK);
		 }
         
	}

	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	public List<Employee> getEmployeeByEmail(String email) {
		return employeeRepo.getEmployeeByEmail(email);
	}

	public List<Employee> getEmployeeByName(String name) {
		return employeeRepo.getEmployeeByName(name);
	}

	public Employee getEmployeeByEmpId(long empId) {
		return employeeRepo.findById(empId).get();
	}
	
}
