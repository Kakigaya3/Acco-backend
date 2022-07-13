package com.accolite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accolite.model.Client;
import com.accolite.model.Project;
import com.accolite.model.Response;
import com.accolite.repository.ProjectRepository;

@Service
public class ProjectServices {

	@Autowired
	public ProjectRepository projectRepo;

	public ResponseEntity<Response> addProject(Project project) {
		try
		{
		String id = project.getProjectId();
		Project p = projectRepo.findById(id).get();
		return new ResponseEntity<>(new Response("Project already exist"),HttpStatus.BAD_REQUEST);
		}
		 //System.out.println(e);
		catch(Exception e)
		{
			projectRepo.save(project);
			return new ResponseEntity<>(new Response("New project created successfully"),HttpStatus.OK);
		}
	}

	public Project getProjectByProjectId(String projectId) {
		return projectRepo.findById(projectId).get();
	}

	public List<Project> getProjectByProjectName(String projectName) {
		return projectRepo.getProjectByProjectName(projectName.toLowerCase());
	}

	public List<Project> getAllProject() {
		return projectRepo.findAllProjects();
	} 
	
	public List<Project> getProjectByClientId(int clientId) {
		return projectRepo.getProjectByClientId(clientId);
	} 
	public long findNoOfProjects() {
		return projectRepo.findAll().size()-1;
	}
}
