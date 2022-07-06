package com.consultorio.consultorios.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor

public class NewPacienteDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;
    @Min(message = "Estatura Minima de 50cm", value = 50)
    @Max(message = "Estatura maxima de 200cm",value = 200)
    private float estatura;
    @NotNull(message = "El peso no puede ser nulo")
    private float peso;
    @NotNull(message = "La fecha de ingreso no puede ser nulo")
    private Date fecha_ingreso;
    @NotNull(message = "La edad no puede ser nulo")
    private int edad;
}
