package com.example.Zoo.services;

import com.example.Zoo.dtos.CuidadorDTO;
import com.example.Zoo.models.Cuidador;
import com.example.Zoo.repositories.CuidadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuidadorService {

    @Autowired
    private CuidadorRepository cuidadorRepository;

    public List<CuidadorDTO> findAll() {
        return cuidadorRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<CuidadorDTO> findById(Long id) {
        return cuidadorRepository.findById(id).map(this::toDTO);
    }

    public CuidadorDTO save(CuidadorDTO cuidadorDTO) {
        Cuidador cuidador = toEntity(cuidadorDTO);
        return toDTO(cuidadorRepository.save(cuidador));
    }

    public CuidadorDTO update(Long id, CuidadorDTO cuidadorDTO) {
        return cuidadorRepository.findById(id).map(existingCuidador -> {
            existingCuidador.setNome(cuidadorDTO.getNome());
            existingCuidador.setEspecialidade(cuidadorDTO.getEspecialidade());
            existingCuidador.setTurnoDeTrabalho(cuidadorDTO.getTurnoDeTrabalho());
            return toDTO(cuidadorRepository.save(existingCuidador));
        }).orElse(null); // Or throw an exception
    }

    public void deleteById(Long id) {
        cuidadorRepository.deleteById(id);
    }

    public List<CuidadorDTO> findByEspecialidade(String especialidade) {
        return cuidadorRepository.findByEspecialidade(especialidade).stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<CuidadorDTO> findByTurnoDeTrabalho(String turno) {
        return cuidadorRepository.findByTurnoDeTrabalho(turno).stream().map(this::toDTO).collect(Collectors.toList());
    }

    private CuidadorDTO toDTO(Cuidador cuidador) {
        CuidadorDTO dto = new CuidadorDTO();
        dto.setId(cuidador.getId());
        dto.setNome(cuidador.getNome());
        dto.setEspecialidade(cuidador.getEspecialidade());
        dto.setTurnoDeTrabalho(cuidador.getTurnoDeTrabalho());
        return dto;
    }

    private Cuidador toEntity(CuidadorDTO dto) {
        Cuidador cuidador = new Cuidador();
        // We don't set the ID from the DTO on creation
        cuidador.setNome(dto.getNome());
        cuidador.setEspecialidade(dto.getEspecialidade());
        cuidador.setTurnoDeTrabalho(dto.getTurnoDeTrabalho());
        return cuidador;
    }
}
