package com.forbes1.proj.repositories;

import com.forbes1.proj.entities.Biography;
import com.forbes1.proj.projections.DescriptedBillionaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BillionaireBiographyRepository extends JpaRepository<Biography, Integer> {

    @Query(value = "select person.personid, person.prenom, person.nom, person.age, person.networth, person.unite, person.pays, Biography.biographyid," +
            " Biography.nom as bionom, " +
            " Biography.prenom as bioprenom, " +
            " Biography.biography, " +
            " Biography.personid as persid " +
            " FROM Person JOIN Biography ON person.personid = Biography.personid" +
            " WHERE person.personid = :id", nativeQuery = true)
    public Optional<DescriptedBillionaire> findBiographyByBillionaireid(@Param("id") Integer billid);

    public Optional<DescriptedBillionaire> findBiographyByBillionaire();
}
