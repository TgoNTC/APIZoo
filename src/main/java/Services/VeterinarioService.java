package Services;

import Dtos.VeterinarioDto;
import Models.Veterinario;
import Repositories.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService {

    private final VeterinarioRepository repository;

    public VeterinarioService(VeterinarioRepository repository) {
        this.repository = repository;
    }

    public Veterinario salvar(VeterinarioDto dto) {
        Veterinario veterinario = new Veterinario();
        veterinario.setNome(dto.getNome());
        veterinario.setCRMV(dto.getCRMV());
        veterinario.setEspecialidade(dto.getEspecialidade());
        return repository.save(veterinario);
    }

    public List<Veterinario> listar() {
        return repository.findAll();
    }

    public Optional<Veterinario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Veterinario atualizar(Long id, VeterinarioDto dto) {
        return repository.findById(id).map(veterinario -> {
            veterinario.setNome(dto.getNome());
            veterinario.setCRMV(dto.getCRMV());
            veterinario.setEspecialidade(dto.getEspecialidade());
            return repository.save(veterinario);
        }).orElseThrow(() -> new RuntimeException("Veterinário não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
