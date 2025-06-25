package com.thaisefreitas.doacoesapi.repository;

import com.thaisefreitas.doacoesapi.model.Doacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {
    // aqui você pode adicionar consultas personalizadas se precisar
}

