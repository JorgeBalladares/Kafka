package com.example.EJ2.Configuration.Feign;

import com.example.EJ2.Profesor.infraestructure.dto.OutPuts.ProfesorOutFullDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="simpleFeign",url="http://localhost:8081/")
public interface IFeignServer {


    @GetMapping("server/feign/getProfesor/{id}")
    public ResponseEntity<ProfesorOutFullDTO> callUsingFeigngetProfesor(@PathVariable String id) throws Exception;
}
