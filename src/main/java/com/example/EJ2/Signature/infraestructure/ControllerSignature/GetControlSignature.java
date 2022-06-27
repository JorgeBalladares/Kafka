package com.example.EJ2.Signature.infraestructure.ControllerSignature;

import com.example.EJ2.Signature.Application.UserCases.SignatureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetControlSignature {

    @Autowired
    SignatureServiceImpl servSign;


    @GetMapping("/signature/{id}")
    public Object gettingSignature(@PathVariable(name = "id") String id,
                             @RequestParam(name = "outputType", defaultValue = "simple") String outputType) throws Exception {
        return servSign.findSignature(id, outputType);

    }
}
