package br.com.firstProjSpring.firstprojspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Livro getlivro() {
		return new Livro();
	}
	
	@Bean 
	public IAutorLivro getAutorLivro() {
		return new Autor();
	}
 }
