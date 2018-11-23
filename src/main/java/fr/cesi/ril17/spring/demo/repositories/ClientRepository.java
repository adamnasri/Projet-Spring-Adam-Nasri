package fr.cesi.ril17.spring.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.cesi.ril17.spring.demo.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
	List<Client> findByLastname(String lastname);
}
