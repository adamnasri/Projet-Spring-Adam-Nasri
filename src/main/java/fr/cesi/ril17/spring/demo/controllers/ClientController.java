package fr.cesi.ril17.spring.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.cesi.ril17.spring.demo.entities.Client;
import fr.cesi.ril17.spring.demo.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<Client> getClientByName(@PathVariable String name) {
		return new ResponseEntity<Client>(
				clientService.findByName(name), 
				HttpStatus.OK);
	}
	
	

}
