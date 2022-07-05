package com.accolite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.model.Employee;
import com.accolite.repository.EmployeeRepository;

@Service
public class EmployeeServices {

	@Autowired
	public EmployeeRepository employeeRepo;
	
	public void addemployee(Employee employee) {
         employeeRepo.save(employee);
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
