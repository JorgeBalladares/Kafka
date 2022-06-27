package com.example.EJ2.Student.infraestructure.dto;


import com.example.EJ2.Signature.infraestructure.dto.Outputs.OutSimpleSingatureDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class StudentSimpleDTO {

    private String id_student;
    private int num_hours_week;
    private String branch;
    private List<OutSimpleSingatureDTO> signatures;



}
