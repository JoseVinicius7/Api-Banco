package br.com.banco.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.banco.controller.dto.PessoaDto;
import br.com.banco.controller.form.AtualizacaoPessoaForm;
import br.com.banco.controller.form.PessoaForm;
import br.com.banco.modelo.Pessoa;
import br.com.banco.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class HomeController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> Hello() {

		return pessoaService.findAll();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PessoaDto> cadastrar(@RequestBody @Valid PessoaForm form, UriComponentsBuilder uriBuilder) {
		Pessoa pessoa = pessoaService.save(form);
		
		URI uri = uriBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity. created(uri).body(new PessoaDto(pessoa));
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDto> detalhar(@PathVariable Long id) {
		Pessoa pessoa = pessoaService.findById(id);

		return ResponseEntity.ok(new PessoaDto(pessoa));

	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PessoaDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoPessoaForm form) {
		Pessoa pessoa = pessoaService.update(id, form);
		
		return ResponseEntity.ok(new PessoaDto(pessoa));
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		pessoaService.delete(id);
		
		return ResponseEntity.noContent().build();
	}


}
	
	

