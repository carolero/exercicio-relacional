package com.br.spring.relacional.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.models.Usuario;
import com.br.spring.relacional.services.LoginService;
import com.br.spring.relacional.services.UsuarioService;

@Controller
public class CadastroController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/")
	public ModelAndView mostrarUsuario() {
		ModelAndView modelAndView = new ModelAndView("cadastro.html");
		return modelAndView;
	}
	
	@PostMapping("/")
	public ModelAndView cadastrarUsuario(@Valid Usuario usuario, BindingResult bindingResultUser, @Valid Login login, BindingResult bindingResultLogin) {
		ModelAndView modelAndView = new ModelAndView("cadastro.html");
		if(bindingResultUser.hasErrors() || bindingResultLogin.hasErrors()) {
			List<String> mensagem = new ArrayList<String>();
			for (ObjectError objectError : bindingResultUser.getAllErrors()) {
				mensagem.add(objectError.getDefaultMessage());
			}
			for (ObjectError objectError : bindingResultLogin.getAllErrors()) {
				mensagem.add(objectError.getDefaultMessage());
			}
			modelAndView.addObject("mensagem", mensagem);
			return modelAndView;
		} else {
			modelAndView.addObject("mensagem", loginService.cadastrarLogin(usuario, login));
		}
		return modelAndView;
	}

}
