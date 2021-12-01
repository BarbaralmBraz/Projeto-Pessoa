package com.br.projeto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.br.projeto.entity.Pessoa;
import com.br.projeto.model.PessoaRequest;
import com.br.projeto.model.PessoaResponse;
import com.br.projeto.repository.PessoaRepository;

@Service
public class PessoaService {
	
	private final PessoaRepository repository;
	
	public PessoaService(PessoaRepository repository) {
		this.repository = repository;
	}
	
	public Pessoa save(PessoaRequest pessoaDTO) {
		return this.repository.save(convertePessoaRequestParaPessoa(pessoaDTO));
	}
	
	public List<PessoaResponse> list(){
		return this.repository.findAll()
				.stream()
				.map(p-> convertePessoaResponse(p))
				.collect(Collectors.toList());
	}
	
	private Pessoa convertePessoaRequestParaPessoa(PessoaRequest pessoaDTO) {
		return Pessoa.builder()
				.nome(pessoaDTO.getNome())
				.email(pessoaDTO.getEmail())
				.telefone(pessoaDTO.getTelefone())
				.build();		
	}
	
	private PessoaResponse convertePessoaResponse(Pessoa pessoa) {
		return PessoaResponse.builder()
				.id(pessoa.getId())
				.nome(pessoa.getNome())
				.email(pessoa.getEmail())
				.telefone(pessoa.getTelefone())
				.build();	
	
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}

}
