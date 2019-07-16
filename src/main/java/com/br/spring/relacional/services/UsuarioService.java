package com.br.spring.relacional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.relacional.models.Usuario;
import com.br.spring.relacional.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void cadastrarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

}
