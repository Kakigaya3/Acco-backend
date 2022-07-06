package com.accolite.repository;

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
	@Query(value = "select * from project p where p.project_name = ?1", nativeQuery = true)
	Optional<Project> getProjectByProjectName(@Param("projectName") String projectName);

}
