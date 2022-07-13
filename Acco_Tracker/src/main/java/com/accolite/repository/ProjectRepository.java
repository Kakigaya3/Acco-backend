package com.accolite.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

	@Transactional
	@Query(value = "select * from project p where p.project_name like %?1% ", nativeQuery = true)
	List<Project> getProjectByProjectName(@Param("projectName") String projectName);
	
	
	@Transactional
	@Query(value = "select * from project p where p.client_id = ?1", nativeQuery = true)
	List<Project> getProjectByClientId(int clientId);
	
	@Transactional
	@Query(value = "select * from project p where p.project_id!=' '", nativeQuery = true)
	List<Project> findAllProjects();

}
