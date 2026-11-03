package com.ecosem.backend.service;

import com.ecosem.backend.entity.Trabajador;
import com.ecosem.backend.repository.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorService {

    // Inyectamos el repositorio para poder usar sus comandos SQL
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    // Regla de negocio 1: Listar todos los trabajadores registrados
    public List<Trabajador> obtenerTodosLosTrabajadores() {
        return trabajadorRepository.findAll();
    }

    // Regla de negocio 2: Registrar un nuevo trabajador en el sistema
    public Trabajador registrarTrabajador(Trabajador trabajador) {
        // Como el DNI lo pusimos como unique=true en la entidad, 
        // el repositorio automáticamente rechazará duplicados.
        return trabajadorRepository.save(trabajador);
    }
}