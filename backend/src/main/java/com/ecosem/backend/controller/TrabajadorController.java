package com.ecosem.backend.controller;

import com.ecosem.backend.entity.Trabajador;
import com.ecosem.backend.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trabajadores")
@CrossOrigin(origins = "*") // Permite que tu frontend de React no sea bloqueado por seguridad
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    // Cuando React visite: GET http://localhost:9000/api/trabajadores
    @GetMapping
    public List<Trabajador> listarTrabajadores() {
        return trabajadorService.obtenerTodosLosTrabajadores();
    }

    // Cuando React envíe datos a: POST http://localhost:9000/api/trabajadores
    @PostMapping
    public Trabajador registrarTrabajador(@RequestBody Trabajador trabajador) {
        return trabajadorService.registrarTrabajador(trabajador);
    }
}