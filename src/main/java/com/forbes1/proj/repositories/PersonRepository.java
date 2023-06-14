package com.forbes1.proj.repositories;

import com.forbes1.proj.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>, CrudRepository<Person, Integer> {

    @Query(value = "select person.personid, person.prenom, person.nom, person.age, person.networth, person.unite, person.pays" +
            "       from person " +
            "       where person.pays = :country", nativeQuery = true)
    public List<Person> findPersonByCountry(String country);

    @Query(value = "select person.personid, person.prenom, person.nom, person.age, person.networth, person.unite, person.pays  " +
            "from person  " +
            "order by person.networth desc " +
            "limit 10", nativeQuery = true)
    public List<Person> findTopTen();

    @Query(value = "select person.personid, person.prenom, person.nom, person.age, person.networth, person.unite, person.pays " +
            "from person " +
            "where person.pays in ('nigeria', 'rsa', 'egypt', 'morroco', 'tunisia', 'cameroon', 'ivory cost', 'senegal', 'algeria') " , nativeQuery = true)
    public List<Person> selectAfrica();
}
