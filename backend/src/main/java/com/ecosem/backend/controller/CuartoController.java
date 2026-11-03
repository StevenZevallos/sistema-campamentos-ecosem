package com.ecosem.backend.controller;

import com.ecosem.backend.entity.Cuarto;
import com.ecosem.backend.service.CuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuartos")
@CrossOrigin(origins = "*")
public class CuartoController {
    @Autowired
    private CuartoService cuartoService;

    @GetMapping
    public List<Cuarto> listarCuartos() {
        return cuartoService.obtenerTodosLosCuartos();
    }

    @PostMapping
    public Cuarto registrarCuarto(@RequestBody Cuarto cuarto) {
        return cuartoService.registrarCuarto(cuarto);
    }
}