package com.testopa.testopa.api;

import com.testopa.testopa.domain.Product;
import com.testopa.testopa.repository.ProductRepository;
import com.testopa.testopa.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepo;
    private SellerRepository sellerRepo;

    //Constructeur utilisé pour initialiser les repository
    @Autowired
    public ProductController(ProductRepository productRepo, SellerRepository sellerRepo) {
        super();
        this.productRepo = productRepo;
        this.sellerRepo = sellerRepo;
    }

    //get
    @GetMapping("/")
    public ResponseEntity<List<Product>> list(){
        return new ResponseEntity<List<Product>>(productRepo.findAll(), HttpStatus.OK);
    }


    //create
    @PostMapping("/")
    public ResponseEntity<Product> save(Product product){
        return new ResponseEntity<Product>(productRepo.save(product), HttpStatus.OK);
    }

    //update

    @PutMapping("/{id}")
    public void put(@RequestBody Product p, @PathVariable long id){
        Optional<Product> optionalP = productRepo.findById(id);
        if(optionalP.isPresent()) {

            p.setId(id);

            productRepo.save(p);
        }
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        productRepo.deleteById(id);
    }
}