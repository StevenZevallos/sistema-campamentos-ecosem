package com.ecosem.backend.service;

import com.ecosem.backend.entity.UsuarioSistema;
import com.ecosem.backend.repository.UsuarioSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioSistemaService {

    @Autowired
    private UsuarioSistemaRepository usuarioSistemaRepository;

    public List<UsuarioSistema> obtenerTodosLosUsuarios() {
        return usuarioSistemaRepository.findAll();
    }

    public UsuarioSistema registrarUsuario(UsuarioSistema usuario) {
        return usuarioSistemaRepository.save(usuario);
    }
}