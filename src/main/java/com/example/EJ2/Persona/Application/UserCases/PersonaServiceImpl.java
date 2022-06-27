package com.example.EJ2.Persona.Application.UserCases;


import com.example.EJ2.Exception.Customizer.UnprocesableException;
import com.example.EJ2.Persona.Application.Services.PersonaService;
import com.example.EJ2.Persona.Domain.Entities.Persona;
import com.example.EJ2.Persona.Domain.repositories.PersonaRepository;
import com.example.EJ2.Persona.Infraestructure.dto.Inputs.PersonaInputDTO;
import com.example.EJ2.Persona.Infraestructure.dto.Outputs.PersonaOutSimpleDTO;
import com.example.EJ2.stringgenerator.StringPrefixedSequenceIdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepositorio;
    @Autowired
    private ModelMapper modelMapper;
    List<Persona> listaPerson;


    public PersonaOutSimpleDTO addPersona(PersonaInputDTO persona) throws Exception {
        Persona p = modelMapper.map(persona, Persona.class);
        if (persona.getUsuario() == null || persona.getPassword() == null || persona.getName() == null || persona.getCompany_email() == null
                || persona.getPersonal_email() == null || persona.getCity() == null ||
                persona.getActive() == null || persona.getCreated_date() == null) {
            throw new Exception("Faltan campos imprescindibles");
        }
        if (persona.getUsuario().length() > 10) {
            throw new UnprocesableException("Valores no válidos");
        } else  {

            personaRepositorio.save(p);

        }
        return modelMapper.map(p, PersonaOutSimpleDTO.class);
    }


    public Object getByID(int id) throws Exception {
        Optional<Persona> person = personaRepositorio.findById(id);
        Persona p = modelMapper.map(person, Persona.class);
        if (person.isPresent()) {
           return modelMapper.map(person, PersonaOutSimpleDTO.class);
        }
        return null;
    }


    public List<PersonaInputDTO> getPersonByName(String name) {
        listaPerson = personaRepositorio.findByName(name);
        return listaPerson.stream()
                .map(Persona -> modelMapper.map(Persona, PersonaInputDTO.class))
                .collect(Collectors.toList());
    }

    public PersonaOutSimpleDTO updPerson(int id, PersonaInputDTO personaInputDTO) throws Exception {
        Optional<Persona> persona = personaRepositorio.findById(id);
        Persona persona1 = modelMapper.map(persona, Persona.class);
        Persona person = modelMapper.map(personaInputDTO, Persona.class);
        if(!persona.isPresent()){
            throw new Exception("No existe una persona con el id buscado");
        }
        else {
            if(person.getId()==persona1.getId()) {
                personaRepositorio.save(person);
                return modelMapper.map(person, PersonaOutSimpleDTO.class);
            }
            else {
                throw new Exception("id no asignado, no se puede actualizar");
            }
        }
    }


    public List<PersonaInputDTO> getTotalList() throws Exception {
        List<Persona> lista = personaRepositorio.findAll();

        if (lista != null) {
            return lista.stream()
                    .map(Persona -> modelMapper.map(Persona, PersonaInputDTO.class))
                    .collect(Collectors.toList());
        }
        throw new Exception("Lista vacía");
    }

    public void deleteObj(int id) throws Exception {
        personaRepositorio.deleteById(id);
    }


}
