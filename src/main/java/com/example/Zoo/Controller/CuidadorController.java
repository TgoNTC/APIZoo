package com.example.Zoo.Controller;

import com.example.Zoo.DTO.CuidadorDTO;
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
    public List<CuidadorDTO> findAll() {
        return cuidadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CuidadorDTO> findById(@PathVariable Long id) {
        Optional<CuidadorDTO> cuidador = cuidadorService.findById(id);
        return cuidador.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CuidadorDTO create(@RequestBody CuidadorDTO cuidadorDTO) {
        return cuidadorService.save(cuidadorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuidadorDTO> update(@PathVariable Long id, @RequestBody CuidadorDTO cuidadorDTO) {
        CuidadorDTO updatedCuidador = cuidadorService.update(id, cuidadorDTO);
        if (updatedCuidador != null) {
            return ResponseEntity.ok(updatedCuidador);
        } else {
            return ResponseEntity.notFound().build();
        }
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
        } else if (turno != null) {
            return cuidadorService.findByTurnoDeTrabalho(turno);
        } else {
            return cuidadorService.findAll();
        }
    }
}
