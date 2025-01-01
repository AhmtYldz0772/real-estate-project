package com.yildiz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROPERTYS")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROPERTY_ID")
    private Long id;
    @Column(name = "PROPERTY_NAME")
    private String propertyName;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DESCRİPTİON")
    private String description;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "LOCATİON")
    private String location;
    @Column(name = "PRİCE")
    private BigDecimal price;

    /*
    private short bedroom;
    private short bathroom;
    private float area;
    */

    @ManyToOne
    @JoinColumn(name = "agent_id")
    Agent agent;


    @ManyToMany
            @JoinTable(name = "PROPERTIES_BUYERS",
            joinColumns = @JoinColumn(name = "property_id"),
                    inverseJoinColumns = @JoinColumn(name = "buyer_id")
            )
    Set<Buyer> buyers = new HashSet<>();



    @ManyToOne
    @JoinColumn(name = "seller_id")
    Seller  seller;


    public int hesapla(){
        return 100;
    }

    int f(int x){
        return 2*x + 1;
    }


    }
