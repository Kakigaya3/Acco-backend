package com.accolite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accolite.dto.Response;
import com.accolite.dto.projectDto;
import com.accolite.model.Client;
import com.accolite.model.Project;
import com.accolite.model.ProjectDto;

import com.accolite.repository.ProjectRepository;

@Service
public class ProjectServices {

	@Autowired
	public ProjectRepository projectRepo;

	public ResponseEntity<Response> addProject(Project project) {
	    String scode = project.getSwiftCode();
		Project p = projectRepo.findBySwiftCode(scode);
		if(p!=null)
		{
		return new ResponseEntity<>(new Response("Project already exist"),HttpStatus.BAD_REQUEST);
		}
		else
		{
			projectRepo.save(project);
			return new ResponseEntity<>(new Response("New project created successfully"),HttpStatus.OK);
		}
	}


//	public Project getProjectByProjectId(String projectId) {
//		return projectRepo.findById(projectId).get();
//	}
//
//
	public List<ProjectDto> getProjectByProjectName(String projectName) {
		return projectRepo.getProjectByProjectName(projectName.toLowerCase());

	}

	public List<ProjectDto> getAllProject() {

		return projectRepo.getAllProject();
	} 
	
//	public List<Project> getProjectByClientId(int clientId) {
//		return projectRepo.getProjectByClientId(clientId);
//
//	}

	public List<ProjectDto> getProjectBySwiftCode(String swiftCode) {
		return projectRepo.getProjectBySwiftCode(swiftCode);
	} 
	
	
	
	public long findNoOfProjects() {
		return projectRepo.findAll().size()-1;
	}


	public List<ProjectDto> getProjectByClientName(String clientName) {
		return projectRepo.getProjectByClientName(clientName);
	}

//	public ResponseEntity<Response> updateStatus(Long projectId, Integer isActive) {
//		try
//		{
//			projectRepo.updateStatus(projectId, isActive);
//			return new ResponseEntity<>(new Response("Updated Status"),HttpStatus.OK);
//		}
//		catch(Exception e)
//		{
//			return new ResponseEntity<>(new Response("Cannot Update.. Check the clientid"),HttpStatus.BAD_REQUEST);
//		}
//	}
	
	
	public List<ProjectDto> updateStatus(String swiftcode, int status) {
		try {
			System.out.println("hi");
			projectRepo.updateStatus(swiftcode,status);
			return projectRepo.getAllProject();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	public List<Project> getProjectByClientId(long clientId) {
		return projectRepo.getProjectByClientId(clientId);
	}
}
