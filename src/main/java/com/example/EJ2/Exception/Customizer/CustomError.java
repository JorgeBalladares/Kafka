package com.example.EJ2.Exception.Customizer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data


public class CustomError {
    private Date timestamp;
    private int httpCode;
    private String mensaje;

    public CustomError(Date timestamp, int httpCode, String mensaje) {
        this.timestamp = timestamp;
        this.httpCode = httpCode;
        this.mensaje = mensaje;
    }
}

