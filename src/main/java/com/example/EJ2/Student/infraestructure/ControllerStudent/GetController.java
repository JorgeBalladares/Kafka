package com.example.EJ2.Student.infraestructure.ControllerStudent;

import com.example.EJ2.Student.application.UserCase.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @Autowired
    StudentServiceImpl servStud;

    @GetMapping("student/{id}")
    public Object getEstudianteById(@PathVariable(name = "id") String id,
                                    @RequestParam(name = "outputType", defaultValue = "simple") String outputType) throws Exception {
        return servStud.findId(id, outputType);

    }
}
