package com.accolite.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
//	@PostMapping("/addProject")
//	public ResponseEntity<Response> addProject(@RequestParam("project") String proj) throws IOException
//	{   
//		ObjectMapper obj=new ObjectMapper();
//		obj.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
//		Project project=obj.readValue(proj,Project.class);
//		return projectservices.addProject(project);
//		
//	}
	
	@PostMapping("/addProject")
	public ResponseEntity<Response> addProject(@RequestBody Project project)
	{
		return projectservices.addProject(project);
	}
	
	
	@GetMapping("/getProjectBySwiftCode")
	public Project getProjectBySwiftCode(@RequestParam String swiftCode)
	{
		return projectservices.getProjectBySwiftCode(swiftCode);
	}
	
	@GetMapping("/getAllProject")

	public List<Project> getAllProject()
	{
		return projectservices.getAllProject();
	}
	
//	@GetMapping("/getProjectByProjectName")
//	public List<Project> getProjectByProjectName(@RequestParam("name") String projectName)
//	{
//		System.out.println(projectName);
//		return projectservices.getProjectByProjectName(projectName);
//	}
//	
//	@GetMapping("/getProjectByClientName")
//	public List<Project> getProjectByClientName(@RequestParam String clientName)
//	{
//			return projectservices.getProjectByClientName(clientName);
//	}
//	
	
}
