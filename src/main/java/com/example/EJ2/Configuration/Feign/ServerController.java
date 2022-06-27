package com.example.EJ2.Configuration.Feign;

import com.example.EJ2.Profesor.application.UserCases.ProfesorServiceImpl;
import com.example.EJ2.Profesor.infraestructure.dto.OutPuts.ProfesorOutFullDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("server")
public class ServerController {

    @Autowired
    ProfesorServiceImpl profesorService;
    @Autowired
    ModelMapper model;

    @GetMapping("/feign/getProfesor/{id}")
    public ResponseEntity<ProfesorOutFullDTO> callUsingFeigngetProfesor(@PathVariable String id,
                                                                        @RequestParam(name = "outputType", defaultValue = "simple") String outputType) throws Exception{
        Object prof = profesorService.findIdProf(id, outputType);
        ProfesorOutFullDTO profesor = model.map(prof, ProfesorOutFullDTO.class);
        return ResponseEntity.ok(profesor);
    }

}
