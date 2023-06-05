package com.forbes1.proj.repositories;

import com.forbes1.proj.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>, CrudRepository<Person, Integer> {
}
