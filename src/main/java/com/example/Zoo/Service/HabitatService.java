package com.example.Zoo.Service;

import com.example.Zoo.DTO.AnimalDTO;
import com.example.Zoo.DTO.HabitatDTO;
import com.example.Zoo.Models.Animal;
import com.example.Zoo.Models.Habitat;
import com.example.Zoo.Models.TipoHabitat;
import com.example.Zoo.Repositories.HabitatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatService {
    private HabitatRepository habitatRepository;
    public HabitatService(HabitatRepository habitatRepository){
        this.habitatRepository = habitatRepository;
    }
    public List<Habitat> getAll(){
        return habitatRepository.findAll();
    }
    public Habitat getById(Long id){
        return habitatRepository.findById(id).orElseThrow(()->new RuntimeException("Habitat não encontrado"));
    }
    public List<Habitat> getByTipo(TipoHabitat tipoHabitat){
        return habitatRepository.findByTipo(tipoHabitat);
    }

    public Habitat create(HabitatDTO habitatDTO){
        Habitat habitat = new Habitat();
        habitat.setNome(habitatDTO.nome());
        habitat.setTipo(habitatDTO.tipo());
        habitat.setCapacidadeMaxAnimais(habitatDTO.capacidadeMaxAnimais());
        return habitatRepository.save(habitat);
    }
    public void delete(Long id){
        Habitat habitat = getById(id);
        habitatRepository.delete(habitat);
    }
    public Habitat update(Long id, HabitatDTO habitatDTO){
        Habitat habitat = getById(id);
        habitat.setNome(habitatDTO.nome());
        habitat.setTipo(habitatDTO.tipo());
        habitat.setCapacidadeMaxAnimais(habitatDTO.capacidadeMaxAnimais());
        return habitatRepository.save(habitat);
    }

}
