package com.example.EJ2.Persona.Infraestructure.controller;


import com.example.EJ2.Persona.Application.UserCases.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerGetID {
    @Autowired
    private PersonaServiceImpl servicio;


    @GetMapping(value = "/persona/{id}")
    public Object getById(@PathVariable("id") int id) throws Exception {
        return servicio.getByID(id);
       // try {
            //return ResponseEntity.status(HttpStatus.OK).body(servicio.getByID(id));
        //}catch (Exception e){
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          //  throw new NotFoundException("Valor no encontrado");
        }

}
