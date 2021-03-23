package br.com.banco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.controller.form.AtualizacaoPessoaForm;
import br.com.banco.controller.form.PessoaForm;
import br.com.banco.exception.PessoaNotFoundException;
import br.com.banco.modelo.Pessoa;
import br.com.banco.repository.PessoaRepository;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public Pessoa save(PessoaForm form) {
		Pessoa pessoa = form.converter();
		
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Pessoa findById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		
		return pessoa.orElseThrow(() -> new PessoaNotFoundException("Pessoa de id " + id + " não encontrada."));
	}

	@Override
	public List<Pessoa> findAll() {
		
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa update(Long id, AtualizacaoPessoaForm form) {
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (!optional.isPresent()) {
			throw new PessoaNotFoundException("Pessoa de id " + id + " não encontrada.");
		}
		
		Pessoa pessoa = form.atualizar(id, pessoaRepository);
		return pessoa;
	}

	@Override
	public void delete(Long id) {
		Optional<Pessoa> optional = pessoaRepository.findById(id);
		if (!optional.isPresent()) {
			throw new PessoaNotFoundException("Pessoa de id " + id + " não encontrada.");
		}
		
		pessoaRepository.deleteById(id);
		
	}

}
