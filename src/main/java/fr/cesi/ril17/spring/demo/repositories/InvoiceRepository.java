package fr.cesi.ril17.spring.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.cesi.ril17.spring.demo.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
