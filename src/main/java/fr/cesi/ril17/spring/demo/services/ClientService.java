package fr.cesi.ril17.spring.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cesi.ril17.spring.demo.entities.Client;
import fr.cesi.ril17.spring.demo.repositories.ClientRepository;

@Service
public class ClientService {
	
	private ClientRepository clientRepo;

	@Autowired
	public ClientService(ClientRepository clientRepo) {
		super();
		this.clientRepo = clientRepo;
	}
	
	public Client findByName(String name) {
		List<Client> clients = clientRepo.findByLastname(name);
		return (clients.isEmpty()) ?  null : clients.get(0);
	}

}
