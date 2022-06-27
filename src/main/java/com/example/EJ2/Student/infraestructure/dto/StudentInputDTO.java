package com.example.EJ2.Student.infraestructure.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentInputDTO {

    private String id_student;
    private String persona;
    private int num_hours_week;
    private String profesor;
    private String branch;


}
