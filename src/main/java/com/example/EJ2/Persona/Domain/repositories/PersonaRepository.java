package com.example.EJ2.Persona.Domain.repositories;


import com.example.EJ2.Persona.Domain.Entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableMongoRepositories
public interface PersonaRepository extends MongoRepository<Persona,Integer> {
    List<Persona> findByName(String name);
}
