package com.example.EJ2.Signature.infraestructure.dto.Inputs;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class InputSignatureDTO {

    private String codAsignatura;

    private String student;

    private String asignatura;

    private String coments;

    private Date initial_Date;

    private Date finish_date;
}
