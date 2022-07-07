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

	public List<Project> getProjectByProjectName(String projectName) {
		return projectRepo.getProjectByProjectName(projectName.toLowerCase());
	}

	public List<Project> getAllProject() {
		return projectRepo.findAll();
	} 
	
	public List<Project> getProjectByClientId(int clientId) {
		return projectRepo.getProjectByClientId(clientId);
	} 
}
