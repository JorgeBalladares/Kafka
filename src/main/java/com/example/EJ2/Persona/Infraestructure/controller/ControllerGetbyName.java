package com.example.EJ2.Persona.Infraestructure.controller;


import com.example.EJ2.Persona.Application.UserCases.PersonaServiceImpl;
import com.example.EJ2.Persona.Infraestructure.dto.Inputs.PersonaInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControllerGetbyName {
    @Autowired
    private PersonaServiceImpl servicio;

    /*
    @GetMapping(value = "/nombre/{name}")
    public List<PersonaDTO> getByName(@PathVariable("name") String name){
       List<Persona> lista = repo.findByName(name);
        List<PersonaDTO> lista2 = new ArrayList<>();
        for (int i = 0; i<lista.size(); i++){
            lista2.add(model.map(lista.get(i), PersonaDTO.class));
        }
       //lista.add(p1);
        return lista2;
    }*/

    @GetMapping(value = "/nombre/{name}")
    public ResponseEntity <List<PersonaInputDTO>> getByName(@PathVariable("name") String name) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicio.getPersonByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
