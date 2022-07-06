package com.accolite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.model.Client;
import com.accolite.repository.ClientRepository;

@Service
public class ClientServices {

	@Autowired
	public ClientRepository clientRepo;
	
	public void addClient(Client client)
	{
		clientRepo.save(client);
	}

	
	public List<Client> getAllClient() {
		return clientRepo.findAll();
	}

	
	public List<Client> getClientByClientName(String clientName) {
		return clientRepo.getClientByClientName(clientName);
	}


	public List<Client> getClientByDomainName(String domainName) {
		return clientRepo.getClientByDomainName(domainName);
	}

	
}
