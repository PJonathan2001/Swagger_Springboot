package com.consultorio.consultorios.services;

import java.util.List;

import com.consultorio.consultorios.dto.NewPacienteDTO;
import com.consultorio.consultorios.dto.PacienteDTO;

public interface PacienteServices {
    public PacienteDTO create(NewPacienteDTO pacienteDTO);
    public PacienteDTO retrieve(Long id) ;
    public PacienteDTO update(PacienteDTO pacienteDTO, Long id) ;
    public void delete(Long id) ;

    public List<PacienteDTO> list();
}
