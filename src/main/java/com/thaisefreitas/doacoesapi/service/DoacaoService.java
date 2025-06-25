package com.thaisefreitas.doacoesapi.service;

import com.thaisefreitas.doacoesapi.model.Doacao;
import com.thaisefreitas.doacoesapi.repository.DoacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository doacaoRepository;

    public List<Doacao> listarTodas() {
        return doacaoRepository.findAll();
    }

    public Optional<Doacao> buscarPorId(Long id) {
        return doacaoRepository.findById(id);
    }

    public Doacao salvar(Doacao doacao) {
        return doacaoRepository.save(doacao);
    }

    public Doacao atualizar(Long id, Doacao doacaoAtualizada) {
        return doacaoRepository.findById(id).map(doacao -> {
            doacao.setNomeDoador(doacaoAtualizada.getNomeDoador());
            doacao.setTipo(doacaoAtualizada.getTipo());
            doacao.setValor(doacaoAtualizada.getValor());
            doacao.setData(doacaoAtualizada.getData());
            return doacaoRepository.save(doacao);
        }).orElseThrow(() -> new RuntimeException("Doação não encontrada com id " + id));
    }

    public void deletar(Long id) {
        doacaoRepository.deleteById(id);
    }
}

