package com.ecosem.backend.controller;

import com.ecosem.backend.entity.UsuarioSistema;
import com.ecosem.backend.service.UsuarioSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioSistemaController {

    @Autowired
    private UsuarioSistemaService usuarioSistemaService;

    @GetMapping
    public List<UsuarioSistema> listarUsuarios() {
        return usuarioSistemaService.obtenerTodosLosUsuarios();
    }

    @PostMapping
    public UsuarioSistema registrarUsuario(@RequestBody UsuarioSistema usuario) {
        return usuarioSistemaService.registrarUsuario(usuario);
    }
}