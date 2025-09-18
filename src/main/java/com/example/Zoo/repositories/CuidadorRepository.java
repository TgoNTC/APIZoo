package com.example.Zoo.Repositories;

import com.example.Zoo.Models.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
    List<Cuidador> findByEspecialidade(String especialidade);
    List<Cuidador> findByTurnoDeTrabalho(String turnoDeTrabalho);
}
