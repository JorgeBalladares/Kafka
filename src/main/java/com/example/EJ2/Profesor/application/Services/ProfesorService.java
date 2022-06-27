package com.example.EJ2.Profesor.application.Services;


import com.example.EJ2.Persona.Domain.Entities.Persona;
import com.example.EJ2.Profesor.infraestructure.dto.InPuts.ProfesorInputDTO;
import com.example.EJ2.Profesor.infraestructure.dto.OutPuts.ProfesorOutFullDTO;

public interface ProfesorService {

    public ProfesorOutFullDTO addProfesor(ProfesorInputDTO inputDTO) throws Exception;
    public Object findIdProf (String id, String outputType) throws Exception;
    public void CheckRoll (Persona person) throws Exception;
    }
