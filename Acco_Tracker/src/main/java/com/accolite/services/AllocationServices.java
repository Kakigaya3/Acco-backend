package com.accolite.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.model.Allocation;
import com.accolite.model.DtoClass;
import com.accolite.repository.AllocationRepository;



@Service
public class AllocationServices {

	@Autowired
	public AllocationRepository allocationRepo;

	public void addAllocation(Allocation allocation) {
		String id=allocation.getEmployeeId();
		Allocation alloc=allocationRepo.getAllocationByEmpId(id);
		if(alloc!=null) {
			alloc.setIsActive(0);
			alloc.setEndDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
			allocationRepo.save(alloc);
		}
        allocationRepo.save(allocation);		
	}

	public List<Map<String, Object>> getAllAllocation() {
        return allocationRepo.getAllAllocation();		
	}

	public List<Map<String, Object>> getAllocationByEmpName(String name) {
		return allocationRepo.getAllocationByEmpName(name);
	}

	public List<Map<String, Object>> getAllocationByEmpEmail(String email) {
		return allocationRepo.getAllocationByEmpEmail(email);
	}
//
//	public List<Map<String, Object>> getAllocationHistoryByEmpEmail(String email) {
//		return allocationRepo.getAllocationHistoryByEmpEmail(email);
//	}
//	
//	public List<Map<String, Object>> getAllocationHistoryByEmpName(String name) {
//		return allocationRepo.getAllocationHistoryByEmpName(name);
//	}
	public List<Map<String, Object>> getAllocationHistory(String empId) {
		return allocationRepo.getAllocationHistory(empId);
	}
}
