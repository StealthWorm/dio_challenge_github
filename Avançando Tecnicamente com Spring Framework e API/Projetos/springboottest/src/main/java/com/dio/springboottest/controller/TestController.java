package com.dio.springboottest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	// teste que envolve comunicação entre as unidades, simulando requisições
	@GetMapping("/test")
	public String saudacao(@RequestParam(name="nome", defaultValue = "DIO") String nome) {
		return String.format("Bem-vindo, %s", nome);
	}
	
/*	
 // esse trecho é utilizados para testes padrão
 * @GetMapping("/test")
	public String saudacao(String nome) {
		return String.format("Bem-vindo, %s", nome);
	}
*/
}
