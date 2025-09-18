package com.example.Zoo.Service;

import com.example.Zoo.DTO.AnimalDTO;
import com.example.Zoo.Models.Animal;
import com.example.Zoo.Repositories.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private AnimalRepository animalRepository;
    public AnimalService(AnimalRepository animalRepository){
        this.animalRepository = animalRepository;
    }
    public List<Animal> getAll(){
       return animalRepository.findAll();
    }
    public Animal getById(Long id){
        return animalRepository.findById(id).orElseThrow(()->new RuntimeException("Animal não encontrado"));
    }
    public Animal create(AnimalDTO animalDTO){
        Animal animal = new Animal();
        animal.setNome(animalDTO.nome());
        animal.setCuidador(animalDTO.cuidador());
        animal.setEspecie(animalDTO.especie());
        animal.setHabitat(animalDTO.habitat());
        animal.setIdade(animalDTO.idade());
        return animalRepository.save(animal);
    }
    public List<Animal> getByAgeRange(Integer idadeMin, Integer idadeMax){
        // Lógica para lidar com os parâmetros opcionais
        if (idadeMin != null && idadeMax != null) {
            return animalRepository.findByAgeBetween(idadeMin, idadeMax);
        } else if (idadeMin != null) {
            return animalRepository.findByAgeGreaterThanEqual(idadeMin);
        } else if (idadeMax != null) {
            return animalRepository.findByAgeLessThanEqual(idadeMax);
        } else {
            return animalRepository.findAll();
        }
    }
    public List<Animal> getBySpecie(String especie){
        return animalRepository.findByEspecie(especie);
    }
    public void delete(Long id){
        Animal animal = getById(id);
        animalRepository.delete(animal);
    }
    public Animal update(Long id, AnimalDTO animalDTO){
        Animal animal = getById(id);
        animal.setNome(animalDTO.nome());
        animal.setCuidador(animalDTO.cuidador());
        animal.setEspecie(animalDTO.especie());
        animal.setHabitat(animalDTO.habitat());
        animal.setIdade(animalDTO.idade());
        return animalRepository.save(animal);
    }
}
