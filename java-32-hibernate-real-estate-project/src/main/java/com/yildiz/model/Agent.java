package com.yildiz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AGENT")
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUYER_ID")
    private Long id;
    @Column(name = "BUYER_NAME")
    private String firstName;
    @Column(name = "BUYER_LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "RATİNG")
    private float rating;
    @Column(name = "USERN_NAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "OFFİCE_ADDRESS")
    private String officeAddress;


    @OneToMany(mappedBy = "agent",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    Set<Property> properties = new HashSet<>();

}
