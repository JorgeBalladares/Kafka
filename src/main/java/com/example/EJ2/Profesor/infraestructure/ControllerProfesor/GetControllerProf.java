package com.example.EJ2.Profesor.infraestructure.ControllerProfesor;

import com.example.EJ2.Profesor.application.UserCases.ProfesorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetControllerProf {

    @Autowired
    ProfesorServiceImpl serProf;

    @GetMapping("prof/{id}")
    public Object findIdProf(@PathVariable(name = "id") String id,
                                    @RequestParam(name = "outputType", defaultValue = "simple") String outputType) throws Exception {
        return serProf.findIdProf(id, outputType);

    }
}
