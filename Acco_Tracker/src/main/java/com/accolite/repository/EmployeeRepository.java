package com.accolite.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select e from Employee e where e.employeeEmail like %?1%")
	List<Employee> getEmployeeByEmail(@Param("email") String email);

	@Query("select e from Employee e where e.employeeName like %?1%")
	List<Employee> getEmployeeByName(@Param("name") String name);
	
	@Query("select e from Employee e where e.employeeId = ?1")
	Employee getEmployeeByEmployeeId(@Param("empId") long empId);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "update employee e   set e.status = ?2 where e.employee_id = ?1",nativeQuery = true)
	void updateEmployee(long empId, String status);
}
