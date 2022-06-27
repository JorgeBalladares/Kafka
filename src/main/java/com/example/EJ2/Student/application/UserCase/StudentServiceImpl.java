package com.example.EJ2.Student.application.UserCase;

import com.example.EJ2.Persona.Domain.Entities.Persona;
import com.example.EJ2.Persona.Domain.repositories.PersonaRepository;
import com.example.EJ2.Profesor.domain.Entities.Profesor;
import com.example.EJ2.Profesor.domain.repositories.ProfesorRepository;
import com.example.EJ2.Signature.domain.Entities.SignatureEntity;
import com.example.EJ2.Signature.domain.repositories.SignatureRepository;
import com.example.EJ2.Signature.infraestructure.dto.Inputs.InputSimpleSignatureDTO;
import com.example.EJ2.Student.application.Services.StudentService;
import com.example.EJ2.Student.domain.Entities.Student;
import com.example.EJ2.Student.domain.repositories.StudentRepository;
import com.example.EJ2.Student.infraestructure.dto.StudentOutputDTOFull;
import com.example.EJ2.Student.infraestructure.dto.StudentInputDTO;
import com.example.EJ2.Student.infraestructure.dto.StudentSimpleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repoStudent;
    @Autowired
    private ModelMapper model;
    @Autowired
    private PersonaRepository repoPerson;
    @Autowired
    private ProfesorRepository repoProf;
    @Autowired
    private SignatureRepository repoSign;


    public StudentOutputDTOFull addStudent(StudentInputDTO inputDTO) throws Exception {
        Optional<Profesor> profe = repoProf.findById(inputDTO.getProfesor());
        Optional<Persona> persona = repoPerson.findById(Integer.parseInt(inputDTO.getPersona()));
        Student student = model.map(inputDTO, Student.class);
        if (!profe.isPresent()) {
            throw new Exception("Profesor con ese id no existe");
        }
        if(!persona.isPresent()) {
            throw new Exception("persona con ese id no existe");
        }
        CheckRoll(model.map(persona, Persona.class)); //Comprobación previa si esta asignado el id ya a otro objeto
        student.setPersona(model.map(persona, Persona.class));
        student.setProfesor(model.map(profe, Profesor.class));
        student.getPersona().setStudent(student); //al ser relacion onetoone hacemos que sea ciclico
        repoStudent.save(student);
        return model.map(student, StudentOutputDTOFull.class);
    }


    public Object findId (String id, String outputType) throws Exception {
        Optional<Student> student = repoStudent.findById(id);
        Student s = model.map(student, Student.class);
        if (!student.isPresent()){
            throw new Exception("No existe");
        }
        if(outputType.equals("full")) {
            return model.map(s, StudentOutputDTOFull.class);
        }
        else {
            return model.map(s, StudentSimpleDTO.class);
        }
    }

    /*----Procedimiento para comprobar si existe ya una asignacion al id,
    se establece en la entidad persona la relacion
                    @onetoone(mapped...)-------*/
    public void CheckRoll (Persona person) throws Exception {
        if (person.getProfesor()!=null){
            throw new Exception("Persona asignada a un profesor");
        }
        else if(person.getStudent()!=null){
            throw new Exception("Persona asignada a un estudiante");
        }
        else{
            System.out.println("añadidos");
        }
    }


    public StudentSimpleDTO addSignaturebyID (String id, InputSimpleSignatureDTO signature) throws Exception {
        Optional<Student> stud = repoStudent.findById(id);
        Student student = model.map(stud, Student.class);
        if (stud.isPresent()){
            List<SignatureEntity> list = student.getSignatures();
            SignatureEntity signa = model.map(signature, SignatureEntity.class);
            signa.setStudent(student);
            signa.getStudent().setId_student(id);
            list.add(signa);
            student.setSignatures(list);
            repoSign.save(signa);
            repoStudent.save(student);
            return model.map(student, StudentSimpleDTO.class);
        }
        throw new Exception("No existe estudiante con ese Id");
    }

    public StudentSimpleDTO removeSignature (String idSignature, String id) throws Exception {

        Optional<Student> stud = repoStudent.findById(id);
        Student student = model.map(stud, Student.class);
        List<SignatureEntity> listaSignature = student.getSignatures();
        Optional<SignatureEntity> signa = repoSign.findById(idSignature);
        SignatureEntity signature = model.map(signa, SignatureEntity.class);

        if (stud.isPresent()){
            if (!listaSignature.contains(signature)) {
                throw new Exception("El usuario no dispone de dicha asignatura");
            }

            listaSignature.remove(signature);
            student.setSignatures(listaSignature);
            signature.setStudent(null);
            repoStudent.save(student);
            repoSign.save(signature);
            return model.map(student, StudentSimpleDTO.class);
        }
        throw new Exception("No existe estudiante con ese Id");
    }


}




