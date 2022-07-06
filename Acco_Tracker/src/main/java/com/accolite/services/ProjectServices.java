package com.accolite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.model.Project;
import com.accolite.repository.ProjectRepository;

@Service
public class ProjectServices {

	@Autowired
	public ProjectRepository projectRepo;

	public void addProject(Project project) {
        	projectRepo.save(project);	
	}

	public Project getProjectByProjectId(String projectId) {
		return projectRepo.findById(projectId).get();
	}

	public Project getProjectByProjectName(String projectName) {
		return projectRepo.getProjectByProjectName(projectName).get();
	}

	public List<Project> getAllProject() {
		return projectRepo.findAll();
	} 
}
