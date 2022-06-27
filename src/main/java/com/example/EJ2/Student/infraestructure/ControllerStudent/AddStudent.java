package com.example.EJ2.Student.infraestructure.ControllerStudent;

import com.example.EJ2.Signature.infraestructure.dto.Inputs.InputSimpleSignatureDTO;
import com.example.EJ2.Student.application.UserCase.StudentServiceImpl;
import com.example.EJ2.Student.infraestructure.dto.StudentOutputDTOFull;
import com.example.EJ2.Student.infraestructure.dto.StudentInputDTO;
import com.example.EJ2.Student.infraestructure.dto.StudentSimpleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddStudent {

    @Autowired
    private StudentServiceImpl servStudent;

    @PostMapping(value = "/addStudent")
    public StudentOutputDTOFull addStudent (@RequestBody StudentInputDTO StuInputDTO) throws Exception {
        return servStudent.addStudent(StuInputDTO);
    }

    @PostMapping (value = "/student/addSignature/{id}")
    public StudentSimpleDTO addSignatureToStudent (@PathVariable ("id") String id, @RequestBody InputSimpleSignatureDTO signature) throws Exception {
        return servStudent.addSignaturebyID(id, signature);
    }



}
