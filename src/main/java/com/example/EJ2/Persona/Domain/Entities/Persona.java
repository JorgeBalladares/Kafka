package com.example.EJ2.Persona.Domain.Entities;

import com.example.EJ2.stringgenerator.StringPrefixedSequenceIdGenerator;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Document (collation = "persona")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Persona {
    @Id //usar generador de codigo automatico
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professorIdGen")
    @GenericGenerator(
            name = "professorIdGen",
            strategy = "com.example.EJ2.stringgenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "Per"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    String id;
    String usuario;
    String name;
    String password;
    String surname;
    String company_email;
    String personal_email;
    String city;
    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;


}
