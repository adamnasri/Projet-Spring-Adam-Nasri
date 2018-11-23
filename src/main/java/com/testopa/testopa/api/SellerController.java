package com.testopa.testopa.api;

import com.testopa.testopa.domain.Product;
import com.testopa.testopa.domain.Seller;
import com.testopa.testopa.repository.ProductRepository;
import com.testopa.testopa.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seller")
public class SellerController {

    private ProductRepository productRepo;
    private SellerRepository sellerRepo;

    //Constructeur utilisé pour initialiser les repository
    @Autowired
    public SellerController(ProductRepository productRepo, SellerRepository sellerRepo) {
        super();
        this.productRepo = productRepo;
        this.sellerRepo = sellerRepo;
    }

    //get
    @GetMapping("/")
    public ResponseEntity<List<Seller>> list(){
        return new ResponseEntity<List<Seller>>(sellerRepo.findAll(), HttpStatus.OK);
    }


    //create
    @PostMapping("/")
    public ResponseEntity<Seller> save(Seller seller){
        return new ResponseEntity<Seller>(sellerRepo.save(seller), HttpStatus.OK);
    }

    //update

    @PutMapping("/{id}")
    public void put(@RequestBody Seller s, @PathVariable long id){
        Optional<Seller> optionalS = sellerRepo.findById(id);
        if(optionalS.isPresent()) {

            s.setId(id);

            sellerRepo.save(s);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        sellerRepo.deleteById(id);
    }
}