package com.example.EJ2.Profesor.domain.Entities;


import com.example.EJ2.Persona.Domain.Entities.Persona;
import com.example.EJ2.stringgenerator.StringPrefixedSequenceIdGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "professor")
@Getter
@Setter
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "professorIdGen")
    @GenericGenerator(
            name = "professorIdGen",
            strategy = "com.example.EJ2.stringgenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "AUS"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    @Column(name = "id_profesor")
    private String id_profesor;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "persona")
    private Persona persona;

    @Column(name = "coments")
    private String coments;

    @Column(name = "branch")
    @NotNull
    @NotBlank
    private String branch;




}
