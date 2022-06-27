package com.example.EJ2.Persona.Infraestructure.dto.Outputs;

import com.example.EJ2.Profesor.infraestructure.dto.OutPuts.ProfesorOutSimpleDTO;
import com.example.EJ2.Student.infraestructure.dto.StudentSimpleDTO;
import lombok.Data;

import java.util.Date;

@Data
public class PersonProfDTOOut {

    private int id;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;
    private Date created_date;
    private String imagen_url;
    private Date termination_date;
    private ProfesorOutSimpleDTO profesor;
    private StudentSimpleDTO student;
}
