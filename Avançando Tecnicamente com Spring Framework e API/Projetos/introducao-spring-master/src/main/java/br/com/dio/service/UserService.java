package br.com.dio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dio.entity.User;
import br.com.dio.repository.UserRepository;

@Service
public class UserService {

	//	Injeção de dependencia por propriedade
	private UserRepository userRepository;

	//	Injeção de dependencia por método
	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		// executa outra regra
		/**
		 * sfbalsdfh
		 */
		this.userRepository = userRepository;
	}

//	Injeção de dependencia por contrutor
//	@Autowired
//	public UserService(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}

	public List<String> buscaDadosBanco() {
		List<String> nomes = new ArrayList<>();
		System.out.println("Chamou o metodo de busca");
		
		return nomes;
	}

	public void deletaDados() {
//		List<Integer> ids = buscaIdsParaDelete();
		System.out.println("Chamou o delete");
//		userRepository.deleteById(1L);
	}

	public User buscaUsuarioPorId(long id) {
		User user = new User();
		user.setNome("Kaique");
		
		userRepository.save(user);
		
		return userRepository.findById(id).get();
	}

}
