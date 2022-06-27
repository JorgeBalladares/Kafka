package com.example.EJ2.Profesor.domain.repositories;

import com.example.EJ2.Profesor.domain.Entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, String> {

}
