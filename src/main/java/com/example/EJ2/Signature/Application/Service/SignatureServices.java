package com.example.EJ2.Signature.Application.Service;

import com.example.EJ2.Signature.infraestructure.dto.Inputs.InputSignatureDTO;
import com.example.EJ2.Signature.infraestructure.dto.Outputs.OutFullSignatureDTO;
import com.example.EJ2.Signature.infraestructure.dto.Outputs.OutSimpleSingatureDTO;

import java.util.List;

public interface SignatureServices {

    public OutFullSignatureDTO addSignature (InputSignatureDTO inputSignature) throws Exception;

    public Object findSignature (String id, String outputType) throws Exception;

    public List<OutSimpleSingatureDTO> getAllSignatureByID(String id) throws Exception;

    public List<OutFullSignatureDTO> getSignatures() throws Exception;

    public OutFullSignatureDTO updateSignature (String id, InputSignatureDTO inputSignature) throws Exception;


}
