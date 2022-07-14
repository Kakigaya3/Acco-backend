package com.accolite.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestPart;
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
	@GetMapping("/noOfClients")
	public long findNoOfClients() {
		return clientservices.findNoOfClients();
	}
	
	@PostMapping("/updatestatus/{clientid}")
	public List<Client> updatestatus(@PathVariable("clientid") Long clientid,@RequestParam String status){
		int stat;
		System.out.println(status);
		if(status.contentEquals("inActive")) {
			stat=0;
		}else {
			stat=1;
		}
		
		System.out.println(stat);
		return clientservices.updatestatus(clientid,stat);
	}
	
}
