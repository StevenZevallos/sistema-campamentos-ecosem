package com.ecosem.backend.service;

import com.ecosem.backend.entity.Asignacion;
import com.ecosem.backend.entity.Cama;
import com.ecosem.backend.repository.AsignacionRepository;
import com.ecosem.backend.repository.CamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private CamaRepository camaRepository;

    public List<Asignacion> obtenerTodasLasAsignaciones() {
        return asignacionRepository.findAll();
    }

    @Transactional
    public Asignacion registrarAsignacion(Asignacion asignacion) {
        // 1. Obtener la cama a asignar desde la BD
        Cama cama = camaRepository.findById(asignacion.getCama().getId())
                .orElseThrow(() -> new RuntimeException("La cama especificada no existe"));

        // 2. Regla de negocio: Verificar si la cama ya está ocupada
        if ("OCUPADA".equalsIgnoreCase(cama.getEstado())) {
            throw new RuntimeException("La cama seleccionada ya se encuentra ocupada");
        }

        // 3. Cambiar automáticamente el estado de la cama a OCUPADA
        cama.setEstado("OCUPADA");
        camaRepository.save(cama);

        // 4. Asignar fecha actual y estado ACTIVA
        asignacion.setFechaInicio(LocalDate.now());
        asignacion.setEstado("ACTIVA");

        return asignacionRepository.save(asignacion);
    }

    @Transactional
    public Asignacion finalizarAsignacion(Long id) {
        Asignacion asignacion = asignacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("La asignación especificada no existe"));

        if ("FINALIZADA".equalsIgnoreCase(asignacion.getEstado())) {
            throw new RuntimeException("Esta asignación ya fue finalizada anteriormente");
        }

        // 1. Cerrar la asignación (Check-out)
        asignacion.setFechaFin(LocalDate.now());
        asignacion.setEstado("FINALIZADA");

        // 2. Liberar la cama asociada automáticamente
        Cama cama = asignacion.getCama();
        cama.setEstado("LIBRE");
        camaRepository.save(cama);

        return asignacionRepository.save(asignacion);
    }
}