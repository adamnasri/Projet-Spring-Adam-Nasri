package com.testopa.testopa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity(name="Seller")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private String Adress;

    //@Length(max = 5)
    private Integer ZipCode;

    private String City;

    @OneToMany(mappedBy="Seller")
    private List<Product> Products;
}

