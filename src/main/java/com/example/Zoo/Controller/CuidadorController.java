package com.example.Zoo.Controller;

import com.example.Zoo.DTO.AnimalDTO;
import com.example.Zoo.DTO.CuidadorDTO;
import com.example.Zoo.Models.Animal;
import com.example.Zoo.Models.Cuidador;
import com.example.Zoo.Service.CuidadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuidadores")
public class CuidadorController {

    @Autowired
    private CuidadorService cuidadorService;

    @GetMapping
    public List<Cuidador> findAll() {
        return cuidadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cuidador> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cuidadorService.getById(id));
    }
    @PostMapping
    public ResponseEntity<Cuidador> create(@RequestBody CuidadorDTO cuidadorDTO){
        return ResponseEntity.ok(cuidadorService.save(cuidadorDTO));
    }

    @PutMapping
    public ResponseEntity<Cuidador> put(@PathVariable Long id, @RequestBody CuidadorDTO cuidadorDTO){
        return ResponseEntity.ok(cuidadorService.update(id, cuidadorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cuidadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public List<CuidadorDTO> findByEspecialidadeOrTurno(
            @RequestParam(required = false) String especialidade,
            @RequestParam(required = false) String turno) {
        if (especialidade != null) {
            return cuidadorService.findByEspecialidade(especialidade);
        } else {
            return cuidadorService.findByTurnoDeTrabalho(turno);
        }
    }
}
