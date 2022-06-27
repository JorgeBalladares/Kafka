package com.example.EJ2.Signature.infraestructure.ControllerSignature;

import com.example.EJ2.Signature.Application.UserCases.SignatureServiceImpl;
import com.example.EJ2.Signature.infraestructure.dto.Inputs.InputSignatureDTO;
import com.example.EJ2.Signature.infraestructure.dto.Outputs.OutFullSignatureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateSignatures {

    @Autowired
    SignatureServiceImpl servSigna;

    @PostMapping("/signature/update/{id}")
    public OutFullSignatureDTO updateSignature (@PathVariable ("id") String id, @RequestBody InputSignatureDTO inputSigna) throws Exception {
        return servSigna.updateSignature(id, inputSigna);
    }

}
