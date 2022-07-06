package com.accolite.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.Allocation;
import com.accolite.model.Project;
import com.accolite.model.Response;
import com.accolite.services.ProjectServices;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	public ProjectServices projectservices;
	
	@PostMapping("/project")
	public Response addProject(@RequestParam String proj) throws IOException
	{   
		ObjectMapper obj=new ObjectMapper();
		obj.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		Project project=obj.readValue(proj,Project.class);
		projectservices.addProject(project);
		return new Response("Allocation done for Employee "+ project.getProjectId());
	}
	
//	@PostMapping("/addProject")
//	public String addProject(@RequestBody Project project)
//	{
//		projectservices.addProject(project);
//		return "Project Created";
//	}
	
	
	@GetMapping("/getProjectByProjectId")
	public Project getProjectByProjectId(@RequestParam String projectId)
	{
		return projectservices.getProjectByProjectId(projectId);
	}
	
	@GetMapping("/getProjectByProjectName")
	public Project getProjectByProjectName(@RequestParam String projectName)
	{
		return projectservices.getProjectByProjectName(projectName);
	}
}