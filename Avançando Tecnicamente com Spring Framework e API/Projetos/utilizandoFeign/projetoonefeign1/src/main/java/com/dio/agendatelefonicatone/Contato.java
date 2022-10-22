package com.dio.agendatelefonicatone;

import lombok.Builder;
import lombok.Data;

// anotações do Loombok, o Data gera Getters e Setters automaticamente
@Data 
@Builder
public class Contato {
	
	private Long id;
	private String nome;
	private String telefone;

}
