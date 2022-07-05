package com.accolite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {

}
