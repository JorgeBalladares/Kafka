package com.example.EJ2.Persona.Domain.Entities;


import com.example.EJ2.Profesor.domain.Entities.Profesor;
import com.example.EJ2.Student.domain.Entities.Student;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity(name = "persona")
@Data


public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "valor usuario obligatorio")
    @Column (name = "usuario", length = 10)
    private String usuario;

    @NotBlank (message = "valor password obligatorio")
    @Column (name = "password")
    private String password;

    @Column (name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "company_email", nullable = false)
    private String company_email;

    @Column(name = "personal_email", nullable = false)
    private String personal_email;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @Column(name = "created_date", nullable = false)
    private Date created_date;

    @Column(name = "imagen_url")
    private String imagen_url;

    @Column(name = "termination_date")
    private Date termination_date;

    @OneToOne(mappedBy = "persona")
    private Profesor profesor;

    @OneToOne(mappedBy = "persona")
    private Student student;




}
