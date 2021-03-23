package br.com.banco.controller.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.banco.modelo.Pessoa;
import br.com.banco.repository.PessoaRepository;

public class AtualizacaoPessoaForm {
	@NotNull	@NotEmpty 	@Length(min = 10)
	private String nome;
	@NotNull	@NotEmpty 	@Length(min = 11)
	private String cpf;
	@NotNull	@NotEmpty
	private String email;
	private Date datanascimento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
	}
	public Pessoa atualizar(Long id, PessoaRepository pessoaRepository) {
		Pessoa pessoa = pessoaRepository.getOne(id);
		pessoa.setNome(this.nome); 
		pessoa.setCpf(this.cpf);
		pessoa.setEmail(this.email);
		pessoa.setDatanascimento(this.datanascimento);
		
		return pessoa;
	
	}
}
