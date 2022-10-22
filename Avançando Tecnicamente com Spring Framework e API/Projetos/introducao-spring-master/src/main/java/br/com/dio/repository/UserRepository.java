package br.com.dio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dio.entity.User;

/*
  caso o @Repository não esteja declarado, ele deixara de ser reconhecido como Bean, então caso vc queira referencia-lo
  sera preciso de uma chamada à classe atraves de outro arquivo de Configuração, no caso desse exemplo ele foi declarado
  na pasta config/BeanConfig com a Annottation "@Configuration" no topo da classe e "@Bean" na chamada da classe UserRepository
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	public void deleteDados() {
//		System.out.println("Apagando dados");
//	}

}
