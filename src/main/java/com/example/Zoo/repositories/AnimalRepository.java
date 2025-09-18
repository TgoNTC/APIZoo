package com.example.Zoo.Repositories;

import com.example.Zoo.Models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findByEspecie(String especie);
    List<Animal> findByIdadeBetween(Integer idadeMin, Integer idadeMax);
    List<Animal> findByIdadeGreaterThanEqual(Integer idadeMin);
    List<Animal> findByIdadeLessThanEqual(Integer idadeMax);

}
