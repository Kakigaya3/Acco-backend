package com.accolite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.model.Client;
import com.accolite.model.Employee;
import com.accolite.model.Response;
import com.accolite.repository.ClientRepository;

@Service
public class ClientServices {

	@Autowired
	public ClientRepository clientRepo;
	
	public Response addClient(Client client) {
		String clientname = client.getClientName();
		List<Client> c = clientRepo.getClientByClientName(clientname);
		 //System.out.println(e);
		if(c.size()!=0)
		{
	     return new Response("Client already exists");
		}
		else
		{
			clientRepo.save(client);
			return new Response("Client created successfully");
		}
	}

	
	public List<Client> getAllClient() {
		return clientRepo.findAll();
	}

	
	public List<Client> getClientByClientName(String clientName) {
		return clientRepo.getClientByClientName(clientName.toLowerCase());
	}


	public List<Client> getClientByDomainName(String domainName) {
		return clientRepo.getClientByDomainName(domainName.toLowerCase());
	}

	
}
