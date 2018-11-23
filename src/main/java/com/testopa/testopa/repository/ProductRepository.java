package com.testopa.testopa.repository;

import com.testopa.testopa.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAll();

    Product save(Product var1);

    void deleteById(Long var1);

    Optional<Product> findById(Long var1);

}
