package com.testopa.testopa.repository;

import com.testopa.testopa.domain.Product;
import com.testopa.testopa.domain.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {
    List<Seller> findAll();

    Seller save(Seller var1);

    void deleteById(Long var1);

    Optional<Seller> findById(Long var1);
}
