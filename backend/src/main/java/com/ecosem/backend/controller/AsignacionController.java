package com.ecosem.backend.controller;

import com.ecosem.backend.entity.Asignacion;
import com.ecosem.backend.service.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
@CrossOrigin(origins = "*")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    @GetMapping
    public List<Asignacion> listarAsignaciones() {
        return asignacionService.obtenerTodasLasAsignaciones();
    }

    @PostMapping
    public Asignacion registrarAsignacion(@RequestBody Asignacion asignacion) {
        return asignacionService.registrarAsignacion(asignacion);
    }

    // Endpoint para hacer Check-Out (liberar cama)
    @PutMapping("/{id}/finalizar")
    public Asignacion finalizarAsignacion(@PathVariable Long id) {
        return asignacionService.finalizarAsignacion(id);
    }
}