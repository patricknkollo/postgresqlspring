package com.forbes1.proj.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private LocalDate age;

    private int networth;
    private String unite;
    private String pays;
}
