package com.br.projeto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.projeto.entity.Pessoa;
import com.br.projeto.model.PessoaRequest;
import com.br.projeto.model.PessoaResponse;
import com.br.projeto.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	private final PessoaService service;
	
	public PessoaController(PessoaService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody PessoaRequest pessoa) {
		return new ResponseEntity<Pessoa>(this.service.save(pessoa), HttpStatus.CREATED);
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<PessoaResponse>> list(){
		return ResponseEntity.ok(this.service.list());
	} 
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@RequestParam("id") Long id) {
		this.service.delete(id);
	}

	

}
