package com.accolite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.model.Employee;
import com.accolite.model.Response;
import com.accolite.repository.EmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	public EmployeeRepository employeeRepo;
	
	public Response addemployee(Employee employee) {
		try {
		String id=employee.getEmployeeId();
		 Employee e=employeeRepo.findById(id).get();
		 //System.out.println(e);
	     return new Response("Employee already exists");
		 }catch(Exception e) {
         employeeRepo.save(employee);
         return new Response("Employee added successfully");
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

	public Employee getEmployeeByEmpId(String empid) {
		return employeeRepo.findById(empid).get();
	}
}
