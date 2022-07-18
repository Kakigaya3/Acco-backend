package com.accolite.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.model.Project;
import com.accolite.model.ProjectDto;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	
	@Transactional
	@Query("select new com.accolite.model.ProjectDto(c.domainName, c.clientName, p.swiftCode, p.division,\r\n"
			+ "			p.superDepartment, p.department, p.projectName, p.projectLocation, \r\n"
			+ "			p.clientSideManager, p.isActive, p.typeOfProject, count(a.swiftCode) as headCount)\r\n"
			+ "				from Project p\r\n"
			+ "			      left join Client c\r\n"
			+ "					 on p.clientId = c.clientId\r\n"
			+ "						left join Allocation a\r\n"
			+ "						   on p.swiftCode = a.swiftCode\r\n"
			+ "                             group by p.swiftCode")
	List<ProjectDto> getAllProject();
	


	@Query(value = "select * from project p where p.swift_code = ?1",nativeQuery = true)
	Project findBySwiftCode(String scode);

	@Query("select new com.accolite.model.ProjectDto(c.domainName, c.clientName, p.swiftCode, p.division, "
			+ "	p.superDepartment, p.department, p.projectName, p.projectLocation, "
			+ "		p.clientSideManager, p.isActive, p.typeOfProject, count(a.swiftCode) as headCount) "
			+ "			from Project p "
			+ "			  left join Client c "
			+ "			     on p.clientId = c.clientId "
			+ "			       left join Allocation a "
			+ "			          on p.swiftCode = a.swiftCode "
			+ "                       where p.swiftCode = ?1 "
			+ "			                  group by p.swiftCode")
	ProjectDto getProjectBySwiftCode(String swiftCode);


	@Query("select new com.accolite.model.ProjectDto(c.domainName, c.clientName, p.swiftCode, p.division, "
			+ "	p.superDepartment, p.department, p.projectName, p.projectLocation, "
			+ "		p.clientSideManager, p.isActive, p.typeOfProject, count(a.swiftCode) as headCount) "
			+ "			from Project p "
			+ "			  left join Client c "
			+ "			     on p.clientId = c.clientId "
			+ "			       left join Allocation a "
			+ "			          on p.swiftCode = a.swiftCode "
			+ "                       where p.projectName like %?1% "
			+ "			                  group by p.swiftCode")
	List<ProjectDto> getProjectByProjectName(String projectName);


	@Query("select new com.accolite.model.ProjectDto(c.domainName, c.clientName, p.swiftCode, p.division, "
			+ "	p.superDepartment, p.department, p.projectName, p.projectLocation, "
			+ "		p.clientSideManager, p.isActive, p.typeOfProject, count(a.swiftCode) as headCount) "
			+ "			from Project p "
			+ "			  left join Client c "
			+ "			     on p.clientId = c.clientId "
			+ "			       left join Allocation a "
			+ "			          on p.swiftCode = a.swiftCode "
			+ "                       where c.clientName like %?1% "
			+ "			                  group by p.swiftCode")
	List<ProjectDto> getProjectByClientName(String clientName);



//	@Modifying(clearAutomatically = true)
//	@Transactional
//	@Query(value = "update project p set is_active = ?2 where p.project_id = ?1", nativeQuery = true)
//	void updateStatus(Long projectId, Integer isActive);

	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE project SET is_active = ?2 WHERE project_id = ?1", nativeQuery = true)
	void updateStatus(Long clientId, int status);
}
