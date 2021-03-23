package br.com.banco.service;

import java.util.List;

import br.com.banco.controller.form.AtualizacaoPessoaForm;
import br.com.banco.controller.form.PessoaForm;
import br.com.banco.modelo.Pessoa;

public interface PessoaService {
	
	public Pessoa save(PessoaForm form);
	
	public Pessoa findById(Long id);
	
	public List<Pessoa> findAll();
	
	public Pessoa update(Long id, AtualizacaoPessoaForm form);
	
	public void delete(Long id);

}
