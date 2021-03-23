package br.com.banco.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.banco.modelo.Pessoa;

public class PessoaDto {
	
	private long id;
	private String nome;
	private String cpf;
	private String email;	
	private Date datanascimento;
	
	public PessoaDto(Pessoa pessoa) {
		
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.cpf= pessoa.getCpf();
		this.email = pessoa.getEmail();
		this.datanascimento= pessoa.getDatanascimento();
		
	}
	
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getcpf() {
		return cpf;
	}
	public String getEmail() {
		return email;
	}
	public Date getDatanascimento() {
		return datanascimento;
	}


	public static List<PessoaDto> converter(List<Pessoa> pessoa) {
			return pessoa.stream().map(PessoaDto :: new).collect(Collectors.toList());
	}


}
