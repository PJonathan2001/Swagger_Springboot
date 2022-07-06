package com.consultorio.consultorios.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.consultorio.consultorios.dto.NewPacienteDTO;
import com.consultorio.consultorios.dto.PacienteDTO;
import com.consultorio.consultorios.exceptions.ResourceNotFoundException;
import com.consultorio.consultorios.models.Paciente;
import com.consultorio.consultorios.repositories.PacienteRepository;
import com.consultorio.consultorios.services.PacienteServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteServiceImpl implements PacienteServices {

    final ModelMapper modelMapper;
    final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(@Autowired PacienteRepository repository, ModelMapper mapper){
        this.pacienteRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public PacienteDTO create(NewPacienteDTO pacienteDTO) {
        Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);        
        return modelMapper.map(paciente, PacienteDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteDTO retrieve(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Pacient not found"));
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Override
    @Transactional
    public PacienteDTO update(PacienteDTO pacienteDTO, Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Pacient not found"));
        
        paciente.setId(id);
        paciente = modelMapper.map(pacienteDTO, Paciente.class);
        pacienteRepository.save(paciente);       

        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Paciente pacient = pacienteRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Pacient not found"));        
        pacienteRepository.deleteById(pacient.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteDTO> list() {
        List<Paciente> pacient = pacienteRepository.findAll();
        return pacient.stream().map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
            .collect(Collectors.toList());        
    }
    
}
