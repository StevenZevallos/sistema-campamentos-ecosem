package com.ecosem.backend.controller;

import com.ecosem.backend.entity.Cama;
import com.ecosem.backend.service.CamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camas")
@CrossOrigin(origins = "*")
public class CamaController {
    @Autowired
    private CamaService camaService;

    @GetMapping
    public List<Cama> listarCamas() {
        return camaService.obtenerTodasLasCamas();
    }

    @PostMapping
    public Cama registrarCama(@RequestBody Cama cama) {
        return camaService.registrarCama(cama);
    }
}