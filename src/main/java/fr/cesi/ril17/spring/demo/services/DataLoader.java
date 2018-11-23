package fr.cesi.ril17.spring.demo.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.cesi.ril17.spring.demo.entities.Client;
import fr.cesi.ril17.spring.demo.entities.Invoice;
import fr.cesi.ril17.spring.demo.repositories.ClientRepository;
import fr.cesi.ril17.spring.demo.repositories.InvoiceRepository;

@Service
public class DataLoader {

	private ClientRepository clientRepo;
	private InvoiceRepository invoiceRepo;

	@Autowired
	public DataLoader(ClientRepository clientRepo, InvoiceRepository invoiceRepo) {
		super();
		this.clientRepo = clientRepo;
		this.invoiceRepo = invoiceRepo;
	}
	
	@PostConstruct
	private void loadData() {
		// create client 
		Client client1 = new Client(null, "Boris", "Ngam", "", null);
		clientRepo.save(client1);
		Invoice invoice1 = new Invoice(null, "",20.00, client1);
		Invoice invoice2 = new Invoice(null, "",20.00, client1);
		invoiceRepo.save(invoice1);
		invoiceRepo.save(invoice2);
	}
	
}
