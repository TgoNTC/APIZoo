package com.example.Zoo.repositories;

import com.example.Zoo.models.Cuidador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuidadorRepository extends JpaRepository<Cuidador, Long> {
    List<Cuidador> findByEspecialidade(String especialidade);
    List<Cuidador> findByTurnoDeTrabalho(String turnoDeTrabalho);
}
