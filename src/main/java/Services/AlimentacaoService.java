package Services;

import Dtos.AlimentacaoDto;
import Models.Alimentacao;
import Repositories.AlimentacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlimentacaoService {

    private final AlimentacaoRepository repository;

    public AlimentacaoService(AlimentacaoRepository repository) {
        this.repository = repository;
    }

    public Alimentacao salvar(AlimentacaoDto dto) {
        Alimentacao alimentacao = new Alimentacao();
        alimentacao.setComida(dto.getComida());
        alimentacao.setQtdDiaria(dto.getQtdDiaria());
        alimentacao.setAnimal(dto.getAnimal());
        return repository.save(alimentacao);
    }

    public List<Alimentacao> listar() {
        return repository.findAll();
    }

    public Optional<Alimentacao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Alimentacao atualizar(Long id, AlimentacaoDto dto) {
        return repository.findById(id).map(alimentacao -> {
            alimentacao.setComida(dto.getComida());
            alimentacao.setQtdDiaria(dto.getQtdDiaria());
            alimentacao.setAnimal(dto.getAnimal());
            return repository.save(alimentacao);
        }).orElseThrow(() -> new RuntimeException("Alimentação não encontrada"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
