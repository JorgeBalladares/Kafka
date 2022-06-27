package com.example.EJ2.Signature.infraestructure.ControllerSignature;

import com.example.EJ2.Signature.Application.UserCases.SignatureServiceImpl;
import com.example.EJ2.Signature.infraestructure.dto.Outputs.OutFullSignatureDTO;
import com.example.EJ2.Signature.infraestructure.dto.Outputs.OutSimpleSingatureDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetSignatures {

    @Autowired
    SignatureServiceImpl servSigna;

    @GetMapping("/getAllSignatures")
    public List<OutFullSignatureDTO> getSignatures() throws Exception {
        return servSigna.getSignatures();
    }

}
