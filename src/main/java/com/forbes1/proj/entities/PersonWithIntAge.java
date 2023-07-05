package com.forbes1.proj.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonWithIntAge {

    private Integer personid;
    private String prenom;
    private String nom;
    private String age;

    private int networth;
    private String unite;
    private String pays;
}
