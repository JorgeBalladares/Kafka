package com.example.EJ2.Profesor.application.UserCases;



import com.example.EJ2.Persona.Domain.Entities.Persona;
import com.example.EJ2.Persona.Domain.repositories.PersonaRepository;
import com.example.EJ2.Profesor.application.Services.ProfesorService;
import com.example.EJ2.Profesor.domain.Entities.Profesor;
import com.example.EJ2.Profesor.domain.repositories.ProfesorRepository;
import com.example.EJ2.Profesor.infraestructure.dto.InPuts.ProfesorInputDTO;
import com.example.EJ2.Profesor.infraestructure.dto.OutPuts.ProfesorOutFullDTO;
import com.example.EJ2.Profesor.infraestructure.dto.OutPuts.ProfesorOutSimpleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    private ProfesorRepository repoProf;
    @Autowired
    private ModelMapper model;
    @Autowired
    private PersonaRepository repoPerson;


    public ProfesorOutFullDTO addProfesor(ProfesorInputDTO inputDTO) throws Exception {
        Optional<Persona> persona = repoPerson.findById(Integer.parseInt(inputDTO.getPersona()));
        if (persona.isPresent()){
            CheckRoll(model.map(persona, Persona.class));
            Profesor profesor = model.map(inputDTO, Profesor.class);
            profesor.setPersona(model.map(persona, Persona.class));
            profesor.getPersona().setProfesor(profesor);
            repoProf.save(profesor);
            return model.map(profesor, ProfesorOutFullDTO.class);
        }
        throw new Exception("kases crack, para");
    }

    /*----Procedimiento para comprobar si existe ya una asignacion al id,
    se establece en la entidad persona la relacion
                    @onetoone(mapped...)-------*/

    public void CheckRoll (Persona person) throws Exception {
        if (person.getProfesor()!=null){
            throw new Exception("Persona asignada a un profesor");
        }
        else if(person.getStudent()!=null){
            throw new Exception("Persona asignada a un estudiante");
        }
        else{
            System.out.println("añadidos");
        }
    }

    public Object findIdProf (String id, String outputType) throws Exception {
        Optional<Profesor> prof = repoProf.findById(id);
        if (!prof.isPresent()){
            throw new Exception("No existe");
        }
        if(outputType.equals("full")) {
            return model.map(prof, ProfesorOutFullDTO.class);
        }
        else {
            return model.map(prof, ProfesorOutSimpleDTO.class);
        }
    }




}
