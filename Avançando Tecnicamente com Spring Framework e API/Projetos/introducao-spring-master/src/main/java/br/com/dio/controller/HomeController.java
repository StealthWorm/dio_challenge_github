package br.com.dio.controller;

import br.com.dio.config.BeanTeste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.dio.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@Autowired
	private BeanTeste teste1;

	@RequestMapping("/")
	public String home(Model model) {

		userService.buscaDadosBanco();
		userService.deletaDados();
		userService.buscaUsuarioPorId(1);

//		model.addAttribute("mensagem", "Hello Word");

		return "home";
	}
}
