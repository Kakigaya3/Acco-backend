package com.accolite.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.Allocation;
import com.accolite.model.DtoClass;
import com.accolite.model.Response;
import com.accolite.services.AllocationServices;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/allocation")
public class AllocationController {

	@Autowired
	public AllocationServices allocationservices;
	
	@PostMapping("/addAllocation")
	public Response addAllocation(@RequestParam("alloc") String alloc) throws IOException
	{   
		ObjectMapper obj=new ObjectMapper();
		obj.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
	    Allocation allocation=obj.readValue(alloc,Allocation.class);
		allocationservices.addAllocation(allocation);
		return new Response("Allocation done for Employee "+ allocation.getEmployeeId());
	}
//	
	@GetMapping("/getAllAllocation")
	public List<Map<String, Object>> getAllAllocation()
	{
		System.out.println(allocationservices.getAllAllocation());
		return allocationservices.getAllAllocation();
	}
//	
	@GetMapping("/getAllocationByEmpName")
	public List<Map<String, Object>> getAllocationByEmpName(@RequestParam String name)
	{
		return allocationservices.getAllocationByEmpName(name);
	}
//	
	@GetMapping("/getAllocationByEmpEmail")
	public List<Map<String, Object>> getAllocationByEmpEmail(@RequestParam String email)
	{
		return allocationservices.getAllocationByEmpEmail(email);
	}
//	
//	@GetMapping("/getAllocationHistoryByEmpEmail")
//	public List<Map<String, Object>> getAllocationHistoryByEmpEmail(@RequestParam String email)
//	{
//		return allocationservices.getAllocationHistoryByEmpEmail(email);
//	}
//	
//	@GetMapping("/getAllocationHistoryByEmpName")
//	public List<Map<String, Object>> getAllocationHistoryByEmpName(@RequestParam String name)
//	{
//		return allocationservices.getAllocationHistoryByEmpName(name);
//	}
	@GetMapping("/getAllocationHistory")
	public List<Map<String, Object>> getAllocationHistory(@RequestParam String empId)
	{
		return allocationservices.getAllocationHistory(empId);
	}
	
}
