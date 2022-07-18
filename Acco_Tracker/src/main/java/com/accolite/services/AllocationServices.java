package com.accolite.services;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.accolite.model.Allocation;

import com.accolite.model.DtoClass;
import com.accolite.model.Response;
import com.accolite.repository.AllocationRepository;

@Service
public class AllocationServices {

	@Autowired
	public AllocationRepository allocationRepo;

////	public void addAllocation(Allocation allocation) {
////		String id=allocation.getEmployeeId();
////		Allocation alloc=allocationRepo.getAllocationByEmpId(id);
////		if(alloc!=null) {
////			alloc.setIsActive(0);
////			alloc.setEndDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
////			allocationRepo.save(alloc);
////		}
////        allocationRepo.save(allocation);		
////	}
//	
////	public void addAllocation(AllocationDto allocationdto)
////        allocationRepo.save(allocationdto);
////	}
//
//	public List<Map<String, Object>> getAllAllocation() {
//        return allocationRepo.getAllAllocation();		
//	}
//
//	public List<Map<String, Object>> getAllocationByEmpName(String name) {
//		return allocationRepo.getAllocationByEmpName(name);
//	}
//
//	public List<Map<String, Object>> getAllocationByEmpEmail(String email) {
//		return allocationRepo.getAllocationByEmpEmail(email);
//	}
//
//	public List<Map<String, Object>> getAllocationByEmpId(String id) {
//		return allocationRepo.getAllocationEmpId(id);
//	}
//
//
//	public List<Map<String, Object>> getAllocationHistory(String empId) {
//		return allocationRepo.getAllocationHistory(empId);
//	}
//
//	public Response checkExistingWork(String empId) {
//		List<Allocation> a=allocationRepo.checkExisitngWork(empId);
//		if(a.size()==0)
//		{
//			System.out.println("No");
//			return new Response("No");
//		}
//		System.out.println("Yes");
//		return new Response("Yes");
//	}
//
//	public ResponseEntity<String> checkAllocation(String empId) {
//	    List<String> notalloted = allocationRepo.checkAllocation(empId);
//	    if(notalloted.contains(empId))
//	    {
//	    	return new ResponseEntity<>(HttpStatus.OK);
//	    }
//	    else
//	    {
//	    	return new ResponseEntity<>("Enter valid employee id",HttpStatus.BAD_REQUEST);
//	    }
//	}
//
//	public ResponseEntity<Response> addAllocation(Allocation allocation) {
//		String id=allocation.getEmployeeId();
//		Allocation alloc=allocationRepo.getAllocationByEmpId(id);
//		if(alloc!=null) {
//			alloc.setIsActive(0);
//			alloc.setEndDate(LocalDateTime.now());
//			allocationRepo.save(alloc);
//		}
//        allocationRepo.save(allocation);
//		return new ResponseEntity<>(new Response("Allocation done seccessfully"), HttpStatus.OK);
//	}
}
