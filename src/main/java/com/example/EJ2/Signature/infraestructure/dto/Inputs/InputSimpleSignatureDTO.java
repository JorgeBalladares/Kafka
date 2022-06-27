package com.example.EJ2.Signature.infraestructure.dto.Inputs;

import lombok.Data;

import java.util.Date;

@Data
public class InputSimpleSignatureDTO {

    private String codAsignatura;

    private String student;

    private String asignatura;

    private String coments;

    private Date initial_Date;

    private Date finish_date;

}
