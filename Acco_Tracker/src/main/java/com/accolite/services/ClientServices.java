package com.accolite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accolite.model.Client;
import com.accolite.model.Employee;
import com.accolite.model.Response;
import com.accolite.repository.ClientRepository;

@Service
public class ClientServices {

	@Autowired
	public ClientRepository clientRepo;
	
	public ResponseEntity<Response> addClient(Client client) {
		String clientname = client.getClientName();
		List<Client> c = clientRepo.getClientByClientName(clientname);
		 //System.out.println(e);
		if(c.size()!=0)
		{
	     return new ResponseEntity<>(new Response("Client already exists"),HttpStatus.BAD_REQUEST);
		}
		else
		{
			clientRepo.save(client);
			return new ResponseEntity<>(new Response("Client created successfully"),HttpStatus.ACCEPTED);
		}
	}

	
	public List<Client> getAllClient() {
		return clientRepo.findAllClients();
	}

	
	public List<Client> getClientByClientName(String clientName) {
		return clientRepo.getClientByClientName(clientName.toLowerCase());
	}


	public List<Client> getClientByDomainName(String domainName) {
		return clientRepo.getClientByDomainName(domainName.toLowerCase());
	}


	public long findNoOfClients() {
		return clientRepo.findAll().size()-1;
	}
	
	public List<Client> updatestatus(long clientId,int status) {
		try {
		clientRepo.updatestatus(clientId,status);
		return clientRepo.findAllClients();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
