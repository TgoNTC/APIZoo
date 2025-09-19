package com.example.Zoo.Service;

import com.example.Zoo.DTO.AnimalDTO;
import com.example.Zoo.DTO.CuidadorDTO;
import com.example.Zoo.Models.Animal;
import com.example.Zoo.Models.Cuidador;
import com.example.Zoo.Repositories.CuidadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CuidadorService {

    @Autowired
    private CuidadorRepository cuidadorRepository;

    public List<Cuidador> findAll() {
        return cuidadorRepository.findAll();
    }

    public Cuidador getById(Long id){
        return cuidadorRepository.findById(id).orElseThrow(()->new RuntimeException("Animal não encontrado"));
    }




    public Cuidador update(Long id, CuidadorDTO cuidadorDTO){
        Cuidador cuidador = getById(id);
        cuidador.setNome(cuidadorDTO.nome());
        cuidador.setEspecialidade(cuidadorDTO.especialidade());
        cuidador.setTurnoDeTrabalho(cuidadorDTO.turnoDeTrabalho());
        cuidador.setEmail(cuidadorDTO.email());
        return cuidadorRepository.save(cuidador);
    }

    public void deleteById(Long id) {
        cuidadorRepository.deleteById(id);
    }

    public List<CuidadorDTO> findByEspecialidade(String especialidade) {
        return cuidadorRepository.findByEspecialidade(especialidade);
    }

    public List<CuidadorDTO> findByTurnoDeTrabalho(String turno) {
        return cuidadorRepository.findByTurnoDeTrabalho(turno);
    }

    public Cuidador save(CuidadorDTO cuidadorDTO) {
        Cuidador cuidador = new Cuidador();
        cuidador.setNome(cuidadorDTO.nome());
        cuidador.setEspecialidade(cuidadorDTO.especialidade());
        cuidador.setTurnoDeTrabalho(cuidadorDTO.turnoDeTrabalho());
        cuidador.setEmail(cuidadorDTO.email());
        return cuidadorRepository.save(cuidador);
    }


    private Cuidador toEntity(CuidadorDTO dto) {
        Cuidador cuidador = new Cuidador();
        cuidador.setNome(dto.nome());
        cuidador.setEspecialidade(dto.especialidade());
        cuidador.setTurnoDeTrabalho(dto.turnoDeTrabalho());
        return cuidadorRepository.save(cuidador);
    }
}
