package br.com.banco.exception;

public class PessoaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PessoaNotFoundException(String message) {
		super(message);
	}
	
}
