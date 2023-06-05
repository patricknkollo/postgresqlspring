package com.forbes1.proj.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personid;
    private String prenom;
    private String nom;
    private Integer age;

    private String networth;
    private String unite;
    private String pays;
}
