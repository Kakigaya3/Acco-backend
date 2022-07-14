package com.accolite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select e from Employee e where e.employeeEmail like ?1%")
	List<Employee> getEmployeeByEmail(@Param("email") String email);

	@Query("select e from Employee e where e.employeeName like ?1%")
	List<Employee> getEmployeeByName(@Param("name") String name);
}
