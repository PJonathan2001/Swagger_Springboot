package com.consultorio.consultorios.models;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "TBL_PACIENTES" )
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ESTATURA")
    private float estatura;
    @Column(name = "PESO")
    private float peso;
    @Column(name = "FECHA_INGRESO")
    private Date fecha_ingreso;
    @Column(name = "EDAD")
    private int edad;
}
