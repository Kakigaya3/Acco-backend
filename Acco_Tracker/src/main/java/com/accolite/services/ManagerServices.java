package com.accolite.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.model.Manager;
import com.accolite.repository.ManagerRepository;

@Service
public class ManagerServices {

	@Autowired
	public ManagerRepository managerRepo;
	
	public String checkuser(String email) {
        try
        {
        	Manager ismanager = managerRepo.findById(email).get();
        }
        catch(Exception e)
        {
        	return "Failure";
        }
        return email;
	}

}
