package com.example.EJ2.Profesor.infraestructure.ControllerProfesor;


import com.example.EJ2.Profesor.application.UserCases.ProfesorServiceImpl;
import com.example.EJ2.Profesor.infraestructure.dto.InPuts.ProfesorInputDTO;
import com.example.EJ2.Profesor.infraestructure.dto.OutPuts.ProfesorOutFullDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddControlProf {

    @Autowired
    private ProfesorServiceImpl profServ;

    @PostMapping(value = "/addProfesor")
    public ProfesorOutFullDTO addProfesor (@RequestBody ProfesorInputDTO inputDTO) throws  Exception{
        return profServ.addProfesor(inputDTO);
    }
}
