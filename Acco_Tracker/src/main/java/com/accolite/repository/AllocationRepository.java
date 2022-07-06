package com.accolite.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.model.Allocation;
import com.accolite.model.AllocationDto;
import com.accolite.model.DtoClass;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {

	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "select  employee_id, employee_name, employee_email, project_name, "
			+ "	project_department, project_location, is_active, client_name, start_date, end_date from (select e.employee_id, e.employee_name, e.employee_email, p.project_name, "
			+ "	p.project_department, p.project_location, a.is_active, c.client_name, a.start_date, a.end_date, row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp "
			+ "	from allocation a join employee e on a.employee_id = e.employee_id "
			+ "	join client c on a.client_id = c.client_id "
			+ "	join project p on a.project_id = p.project_id) as ranks where temp=1 ", nativeQuery = true)
	List<Map<String, Object>> getAllAllocation();

	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "select  employee_id, employee_name, employee_email, project_name, "
			+ "	project_department, project_location, is_active, client_name, start_date, end_date from (select e.employee_id, e.employee_name, e.employee_email, p.project_name, "
			+ "	p.project_department, p.project_location, a.is_active, c.client_name, a.start_date, a.end_date, row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp "
			+ "	from allocation a join employee e on a.employee_id = e.employee_id and e.employee_name like ?1% "
			+ "	join client c on a.client_id = c.client_id "
			+ "	join project p on a.project_id = p.project_id) as ranks where temp=1 ",nativeQuery=true)
	List<Map<String, Object>> getAllocationByEmpName(@Param("name") String name);
//
//	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "select  employee_id, employee_name, employee_email, project_name, "
			+ "	project_department, project_location, is_active, client_name, start_date, end_date from (select e.employee_id, e.employee_name, e.employee_email, p.project_name, "
			+ "	p.project_department, p.project_location, a.is_active, c.client_name, a.start_date, a.end_date, row_number() over (partition by e.employee_id order by a.allocation_id desc) as temp "
			+ "	from allocation a join employee e on a.employee_id = e.employee_id and e.employee_email like ?1%"
			+ "	join client c on a.client_id = c.client_id "
			+ "	join project p on a.project_id = p.project_id) as ranks where temp=1 ",nativeQuery=true)
	List<Map<String, Object>> getAllocationByEmpEmail(@Param("email") String email);
//
//	
//	@Modifying(clearAutomatically=true)
//	@Transactional
//	@Query(value = "select e.employee_id, e.employee_name, e.employee_email, p.project_name, "
//			+ "p.project_department, p.project_location, a.is_active, c.client_name "
//			+ "from allocation a join employee e on a.employee_id = e.employee_id and e.employee_email like ?1% "
//			+ "join client c on a.client_id = c.client_id "
//			+ "join project p on a.project_id = p.project_id ",nativeQuery=true)
//	List<Map<String, Object>> getAllocationHistory(@Param("empId") String email);
	
	@Modifying(clearAutomatically=true)
	@Transactional
	@Query(value = "select e.employee_id, e.employee_name, e.employee_email, p.project_name, "
			+ "p.project_department, p.project_location, a.is_active, c.client_name, start_date, end_date "
			+ "from allocation a join employee e on a.employee_id = e.employee_id and e.employee_id = ?1 "
			+ "join client c on a.client_id = c.client_id "
			+ "join project p on a.project_id = p.project_id "
			+ "order by a.allocation_id desc",nativeQuery=true)
	List<Map<String, Object>> getAllocationHistory(@Param("empId") String empId);

	
//	@Modifying(clearAutomatically=true)
//	@Transactional
//	@Query(value = "INSERT INTO allocation (is_active, project_id, start_date, end_date, modified_on, modified_by, employee_id, client_id) "
//			+ "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
//	void addAllocation(int isActive, String projectId, Date startDate, Date endDate,  Date modifiedOn,  String modifiedBy,  String employeeId, long clientId);
// 
	
	@Transactional
	@Query(value="select * from allocation a where a.employee_id=?1 and a.is_active=1",nativeQuery=true)
	Allocation getAllocationByEmpId(@Param("empId") String empId);
}
