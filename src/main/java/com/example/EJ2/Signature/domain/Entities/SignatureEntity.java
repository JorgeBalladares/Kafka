package com.example.EJ2.Signature.domain.Entities;


import com.example.EJ2.Student.domain.Entities.Student;
import com.example.EJ2.stringgenerator.StringPrefixedSequenceIdGenerator;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "SignatureEntity")
@Getter
@Setter
public class SignatureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "signatureGen")
    @GenericGenerator(
            name = "signatureGen",
            strategy = "com.example.EJ2.stringgenerator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value =
                            "Sign"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value =
                            "%08d")
            })
    @Column(name = "id_asignatura", nullable=false)
    private String codAsignatura;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "student")
    private Student student;

    @Column(name = "asignatura")
    private String asignatura;

    @Column (name = "coments")
    private String coments;

    @Column(name = "initial_date")
    @NotNull
    private Date initial_Date;

    @Column(name = "finish_date")
    private Date finish_date;
}
