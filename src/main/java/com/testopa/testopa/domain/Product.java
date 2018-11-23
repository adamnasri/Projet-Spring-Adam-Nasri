package com.testopa.testopa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name="Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

    private String Name;

    @Column(columnDefinition="TEXT")
    private String Description;
    private String ImageUrl;
    private double Price;
    private Date CreatedOn;

    @ManyToOne(cascade=CascadeType.ALL)
    private Seller Seller;
}
