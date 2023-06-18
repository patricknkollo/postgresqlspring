package com.forbes1.proj.projections;

import org.springframework.beans.factory.annotation.Value;

public class DescriptedBillionaire {

    @Value("#{target.personid}")
    private Integer personid;

    @Value("#{target.prenom}")
    private String prenom;

    @Value("#{target.nom}")
    private String nom;

    @Value("#{target.age}")
    private Integer age;

    @Value("#{target.networth}")

    private String networth;

    @Value("#{target.unite}")
    private String unite;

    @Value("#{target.pays}")
    private String pays;

    @Value("#{target.biographyid}")
    private Integer biographyid;

    @Value("#{target.bionom}")
    private String bionom;

    @Value("#{target.bioprenom}")
    private String bioprenom;

    @Value("#{target.biography}")
    private String biography;

    @Value("#{target.biopersonid}")
    private Integer biopersonid;
}
