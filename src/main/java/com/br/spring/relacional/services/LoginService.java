package com.br.spring.relacional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.models.Usuario;
import com.br.spring.relacional.repositories.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
	public String cadastrarLogin(Usuario usuario, Login login) {
		login.setUsuario(usuario);
		loginRepository.save(login);
		return "Login cadastrado";
	}

}
