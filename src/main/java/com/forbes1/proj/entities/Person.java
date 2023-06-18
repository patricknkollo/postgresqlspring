package com.forbes1.proj.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
//@Builder
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
