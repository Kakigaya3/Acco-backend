package com.accolite.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.dto.projectDto;
import com.accolite.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	
	
	
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
	
	@Query("select new com.accolite.dto.projectDto(c.domainName, c.clientName, p.swiftCode, p.division, "
			+ "	p.superDepartment, p.department, p.projectName, p.projectLocation, "
			+ "		p.clientSideManager, p.isActive, p.typeOfProject, count(a.swiftCode) as headCount) "
			+ "			from Project p "
			+ "			  left join Client c "
			+ "			     on p.clientId = c.clientId "
			+ "			       left join Allocation a "
			+ "			          on p.swiftCode = a.swiftCode "
			+ "                       where p.swiftCode like ?1% "
			+ "			                  group by p.swiftCode")
	List<projectDto> getProjectBySwiftCode(String swiftCode);

	
	@Query("select new com.accolite.dto.projectDto(c.domainName, c.clientName, p.swiftCode, p.division, "
			+ "	p.superDepartment, p.department, p.projectName, p.projectLocation, "
			+ "		p.clientSideManager, p.isActive, p.typeOfProject, count(a.swiftCode) as headCount) "
			+ "			from Project p "
			+ "			  left join Client c "
			+ "			     on p.clientId = c.clientId "
			+ "			       left join Allocation a "
			+ "			          on p.swiftCode = a.swiftCode "
			+ "                       where c.clientName like %?1% "
			+ "			                  group by p.swiftCode")
	List<projectDto> getProjectByClientName(String clientName);
	@Query("select new com.accolite.dto.projectDto(c.domainName, c.clientName, p.swiftCode, p.division, "
			+ "	p.superDepartment, p.department, p.projectName, p.projectLocation, "
			+ "		p.clientSideManager, p.isActive, p.typeOfProject, count(a.swiftCode) as headCount) "
			+ "			from Project p "
			+ "			  left join Client c "
			+ "			     on p.clientId = c.clientId "
			+ "			       left join Allocation a "
			+ "			          on p.swiftCode = a.swiftCode "
			+ "                       where p.projectName like %?1% "
			+ "			                  group by p.swiftCode")
	List<projectDto> getProjectByProjectName(String projectName);



	
	@Query(value = "select * from project p where p.client_id = ?1", nativeQuery = true)
	List<Project> getProjectByClientId(long clientId);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE project SET is_active = ?2 WHERE swift_code = ?1", nativeQuery = true)
	void updateStatus(String swiftcode, int status);
//	division, super_department, department, project_name, project_location, client_side_manager, is_active, type_of_project, 
}
