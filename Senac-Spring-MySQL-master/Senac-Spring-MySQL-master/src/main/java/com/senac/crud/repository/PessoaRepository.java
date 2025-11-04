package com.senac.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senac.crud.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
