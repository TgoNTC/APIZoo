package Controller;

import Dtos.AlimentacaoDto;
import Models.Alimentacao;
import Services.AlimentacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alimentacoes")
public class AlimentacaoController {

    private final AlimentacaoService service;

    public AlimentacaoController(AlimentacaoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Alimentacao> criar(@RequestBody AlimentacaoDto dto) {
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Alimentacao>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alimentacao> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alimentacao> atualizar(@PathVariable Long id, @RequestBody AlimentacaoDto dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
