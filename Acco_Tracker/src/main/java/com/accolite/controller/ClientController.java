package com.accolite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.Client;
import com.accolite.model.Response;
import com.accolite.services.ClientServices;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/client")
public class ClientController {

	@Autowired
	public ClientServices clientservices;
	
	@PostMapping("/addClient")
	public ResponseEntity<Response> addClient(@RequestBody Client client)
	{
		return clientservices.addClient(client);
	}
	
	@GetMapping("/getAllClient")
	public List<Client> getAllClient()
	{
		return clientservices.getAllClient();
	}
	
	@GetMapping("/getClientByClientName")
	public List<Client> getClientByClientName(@RequestParam String clientName)
	{
		return clientservices.getClientByClientName(clientName);
	}
	
	@GetMapping("/getClientByDomainName")
	public List<Client> getClientByDomainName(@RequestParam String domainName)
	{
		return clientservices.getClientByDomainName(domainName);
	}
}
