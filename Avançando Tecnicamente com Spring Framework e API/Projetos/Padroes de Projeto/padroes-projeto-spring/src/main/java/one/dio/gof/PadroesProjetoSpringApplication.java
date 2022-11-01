package one.dio.gof;

import one.dio.gof.model.Cliente;
import one.dio.gof.model.Endereco;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
. Módulos adicionados:
	- Spring Data JPA
	- Spring Web
	- H2 Database
	- OpenFeign
*/
@EnableFeignClients
@SpringBootApplication
public class PadroesProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PadroesProjetoSpringApplication.class, args);

		System.out.println("Design Pattern Observer");
		Endereco e1 = new Endereco("84015450"); //"Rua José Bonifácio", "", "Orfãs", "Ponta Grossa", "PR", "4119905", "", "42", "7777"
		Endereco e2 = new Endereco("83709430");

		Endereco e3 = new Endereco("01001000");
		Endereco e4 = new Endereco("82540094");

		Cliente cliente = new Cliente();
		cliente.subscribe(e1);
		cliente.subscribe(e2);

		// o cliente observa a lista de endereços e atualiza os ceps dependentes assim que detecta uma mudança de valor.
		cliente.setEndereco(e4);

//		cliente.unsubscribe(e2);
//		cliente.setEndereco(e4);
	}
}
