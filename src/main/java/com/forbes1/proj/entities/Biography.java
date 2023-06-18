package com.forbes1.proj.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Biography {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer biographyid;
    private String nom;
    private String prenom;

    @Column(columnDefinition="TEXT", length = 2000)
    private String biography;
    private Integer personid;
}
