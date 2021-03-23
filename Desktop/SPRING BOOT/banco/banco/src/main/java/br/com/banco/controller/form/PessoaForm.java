package br.com.banco.controller.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.banco.modelo.Pessoa;

public class PessoaForm {
	
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

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public Date getDatanascimento() {
		return datanascimento;
	}

	public Pessoa converter() {
		
		return new Pessoa(nome, cpf, email, datanascimento);
	}


}
