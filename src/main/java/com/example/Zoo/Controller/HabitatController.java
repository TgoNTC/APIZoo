package com.example.Zoo.Controller;

import com.example.Zoo.DTO.HabitatDTO;
import com.example.Zoo.Models.Animal;
import com.example.Zoo.Models.Habitat;
import com.example.Zoo.Service.HabitatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitat")
public class HabitatController {
    private HabitatService habitatService;
    public HabitatController(HabitatService habitatService){
        this.habitatService = habitatService;
    }
    @GetMapping
    public ResponseEntity<List<Habitat>> getAll(){
        return ResponseEntity.ok(habitatService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Habitat> getById(Long id){
        return ResponseEntity.ok(habitatService.getById(id));
    }
    @PostMapping
    public ResponseEntity<Habitat> post(@RequestBody HabitatDTO habitatDTO){
        return ResponseEntity.ok(habitatService.create(habitatDTO));
    }
    @PutMapping
    public ResponseEntity<Habitat> put(@PathVariable Long id, @RequestBody HabitatDTO habitatDTO){
        return ResponseEntity.ok(habitatService.update(id, habitatDTO));
    }
    @DeleteMapping
    public ResponseEntity<Habitat> delete(@PathVariable Long id){
        habitatService.delete(id);
        return ResponseEntity.ok().build();
    }

}
