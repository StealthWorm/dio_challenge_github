package br.com.dio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
/*
 Caso voce declare mais de uma @Bean ele vai dar erro por não saber qual referenciar. Ele espera apenas uma Bean na configuração
 O @Bean serve para customizar o conteudo no Spring, ao inves de executar as configs padrão ao declarar uma Anottation na classe(@Repository)
 Por exeplo, caso voce queira fazer um teste de contador antes de realizar cada chamada, dentro do Bean voce adiciona metodos que
 retornam valores no terminal
*/
@Configuration
public class BeanConfig {

//	@Bean
//	public UserRepository userpoRepository() {
//		System.out.println("Iniciando");
//		
//		return new UserRepository();
//	}

//	@Bean
//	@Scope(value = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
//	public BeanTeste beanTeste() {
//		return new BeanTeste();
//	}

// 	@Bean --> escopo de aplicação, uma instancia para varias aplicaçoes.
//	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
//	public BeanTeste beanTeste() {
//		return new BeanTeste();
//	}

	@Bean
	@Scope("prototype")
//
//	@RequestScope --> requisições HTTP
//	@SessionScope --> requisições HTTP por sessao.
//	Caso a sessão (janela) do usuario permaneça aberta ele entende que a sessão ainda existe, então nao apaga a instancia.
//	Caso voce feche a janela e abra de novo ai sim ele cria uma nova sessão.
	public BeanTeste beanTeste() {
		return new BeanTeste();
	}
}
