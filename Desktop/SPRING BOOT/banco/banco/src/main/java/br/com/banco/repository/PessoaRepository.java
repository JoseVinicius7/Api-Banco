package br.com.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.modelo.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
