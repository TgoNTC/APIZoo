package com.example.Zoo.Repositories;

import com.example.Zoo.DTO.CuidadorDTO;
import com.example.Zoo.Models.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
    List<CuidadorDTO> findByEspecialidade(String especialidade);
    List<CuidadorDTO> findByTurnoDeTrabalho(String turnoDeTrabalho);
}
