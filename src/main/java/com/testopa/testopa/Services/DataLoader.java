package com.testopa.testopa.Services;

import com.testopa.testopa.domain.Product;
import com.testopa.testopa.domain.Seller;
import com.testopa.testopa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Service
public class DataLoader {

    private ProductRepository productRepo;
    private SellerRepository sellerRepo;

    //Constructeur utilisé pour initialiser les repository
    @Autowired
    public DataLoader(ProductRepository productRepo, SellerRepository sellerRepo) {
        super();
        this.productRepo = productRepo;
        this.sellerRepo = sellerRepo;
    }

    //Fonction exécutée après le constructeur (du a l'annotation @PostConstruct)
    @PostConstruct
    private void loadData() {

        //reset de la bd
        productRepo.deleteAll();
        sellerRepo.deleteAll();

        //création des listes
        ArrayList<Seller> sellers = new ArrayList<Seller>();
        ArrayList<Product> products = new ArrayList<Product>();

        //création de vendeurs
        Seller seller1 = new Seller(null,"Seller 1","Adress 1",1,"City 1", new ArrayList<Product>());
        Seller seller2 = new Seller(null,"Seller 2","Adress 2",2,"City 2", new ArrayList<Product>());
        Seller seller3 = new Seller(null,"Seller 3","Adress 3",3,"City 3", new ArrayList<Product>());

        // creation de produits
        Product product1 = new Product(null, "Produit 1", "Description 1", "Url 1", 10, null, null);
        Product product2 = new Product(null, "Produit 2", "Description 2", "Url 2", 10, null, null);
        Product product3 = new Product(null, "Produit 3", "Description 3", "Url 3", 10, null, null);
        Product product4 = new Product(null, "Produit 4", "Description 4", "Url 4", 10, null, null);
        Product product5 = new Product(null, "Produit 5", "Description 5", "Url 5", 10, null, null);


        //ajout des relations entre seller et product
        //region
        product1.setSeller(seller1);
        product2.setSeller(seller1);

        product3.setSeller(seller2);
        product4.setSeller(seller2);

        product5.setSeller(seller3);
        //endregion

        //mise a jour des listes
        sellers.add(seller1);
        sellers.add(seller2);
        sellers.add(seller3);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        //ajout de tous les produits dans la base via le repository produit
        //productRepo.save(product1);
        productRepo.saveAll(products);
        sellerRepo.saveAll(sellers);

    }
}
