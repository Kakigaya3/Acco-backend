package com.accolite.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.Allocation;
import com.accolite.model.Client;
import com.accolite.model.Project;
import com.accolite.model.ProjectDto;
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
	
	@GetMapping("/getAllProject")

	public List<ProjectDto> getAllProject()
	{
		return projectservices.getAllProject();
	}
	
	@GetMapping("/getProjectBySwiftCode")
	public ProjectDto getProjectBySwiftCode(@RequestParam String swiftCode)
	{
		return projectservices.getProjectBySwiftCode(swiftCode);
	}
	
	
	

	@GetMapping("/getProjectByProjectName")
	public List<ProjectDto> getProjectByProjectName(@RequestParam String projectName)
	{
		return projectservices.getProjectByProjectName(projectName);
	}
//	
	@GetMapping("/getProjectByClientName")
	public List<ProjectDto> getProjectByClientName(@RequestParam String clientName)
	{
			return projectservices.getProjectByClientName(clientName);
	}
//	
	
//	@GetMapping("/getProjectByClientId")
//	public List<Project> getProjectByClientId(@RequestParam("clientid") String clientId)
//	{
//		
//		int clientid=Integer.valueOf(clientId);
//		return projectservices.getProjectByClientId(clientid);
//	}
	
	
	@GetMapping("/noOfProjects")
	public long findNoOfProjects() {
		return projectservices.findNoOfProjects();
	}
	
//	@PutMapping("/updateStatus")
//	public List<ProjectDto> updateStatus(@RequestParam Long projectId, @RequestParam(required = false) Integer isActive)
//	{
//		projectservices.updateStatus(projectId, isActive);
//		return projectservices.getAllProject();
//	}
	
	@PostMapping("/updateStatus/{projectId}")
	public List<ProjectDto> updateStatus(@PathVariable("projectId") Long projectId,@RequestParam String status){
		int stat;
//		System.out.println(status);
		if(status.contentEquals("inActive")) {
			stat=0;
		}else {
			stat=1;
		}
		
//		System.out.println(stat);
		return projectservices.updateStatus(projectId,stat);
	}
	
	
	}
