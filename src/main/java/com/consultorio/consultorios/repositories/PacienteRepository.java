package com.consultorio.consultorios.repositories;

import java.util.List;

import com.consultorio.consultorios.models.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Long>{
    public List<Paciente> findByNombre(String nombre);
}
