package com.br.projeto.model;

import lombok.Builder;
import lombok.Data;

// Exemplo de DTO.
@Builder
@Data
public class PessoaResponse {
	
	private long id;
	
    private String nome;

    private String email;

    private String telefone;
    
}
