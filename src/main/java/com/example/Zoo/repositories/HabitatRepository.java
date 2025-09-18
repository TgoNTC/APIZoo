package com.example.Zoo.Repositories;

import com.example.Zoo.Models.Animal;
import com.example.Zoo.Models.Habitat;
import com.example.Zoo.Models.TipoHabitat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface HabitatRepository extends JpaRepository<Habitat, Long> {
    List<Habitat> findByTipoHabitat(TipoHabitat tipoHabitat);
}
