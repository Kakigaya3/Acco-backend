package com.accolite.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.dto.projectDto;
import com.accolite.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	@Transactional
	@Query(value = "select * from project p where p.project_name like %?1% ", nativeQuery = true)
	List<Project> getProjectByProjectName(@Param("projectName") String projectName);
	
	
	
	
	@Transactional
	@Query("select   new com.accolite.dto.projectDto(c.domainName, c.clientName, p.swiftCode, p.division, \r\n"
			+ "p.superDepartment, p.department, p.projectName, p.projectLocation, \r\n"
			+ "p.clientSideManager, p.isActive, p.typeOfProject, count(a.swiftCode) as headCount)\r\n"
			+ "	from Project p\r\n"
			+ "      left join Client c\r\n"
			+ "		 on p.clientId = c.clientId\r\n"
			+ "			left join Allocation a\r\n"
			+ "			   on p.swiftCode = a.swiftCode\r\n"
			+ "			      where p.swiftCode is not null group by p.swiftCode")
	List<projectDto> getAllProject();
	


	@Query(value = "select * from project p where p.swift_code = ?1",nativeQuery = true)
	Project findBySwiftCode(String scode);

	@Query(value = "select   c.domain_name, c.client_name, p.swift_code, p.division, \r\n"
			+ "p.super_department, p.department, p.project_name, p.project_location, \r\n"
			+ "p.client_side_manager, p.is_active, p.type_of_project, count(a.swift_code) as headCount\r\n"
			+ "	from project p\r\n"
			+ "      left join client c\r\n"
			+ "		 on p.client_id = c.client_id\r\n"
			+ "			left  join allocation a\r\n"
			+ "			   on p.swift_code = a.swift_code\r\n"
			+ "                  where p.swift_code = ?1",nativeQuery = true)
	Project getProjectBySwiftCode(String swiftCode);

//	division, super_department, department, project_name, project_location, client_side_manager, is_active, type_of_project, 
}
