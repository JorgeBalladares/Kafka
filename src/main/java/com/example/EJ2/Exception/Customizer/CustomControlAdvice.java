package com.example.EJ2.Exception.Customizer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomControlAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<CustomError>  ResponseEntityExceptionHandler (NotFoundException e){
        CustomError error = new CustomError(new Date(), 404, e.getMessage());
        return new ResponseEntity<CustomError>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocesableException.class)
    public final ResponseEntity<CustomError>  handleNotFOUND (NotFoundException e){
        CustomError error = new CustomError(new Date(), 422, e.getMessage());
        return new ResponseEntity<CustomError>(error, HttpStatus.UNPROCESSABLE_ENTITY);
    }


}
