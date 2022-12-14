package br.com.firstProjSpring.firstprojspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Livro livro = factory.getBean(Livro.class);
		livro.setNome("A Torre Negra");
		livro.setCodigo("21FG2FG1DFGD2F");
		
		Autor autor = factory.getBean(Autor.class);
		autor.setNome("Stephen King");
		
		livro.exibir();
		
		((AbstractApplicationContext) factory).close();
	}
}
