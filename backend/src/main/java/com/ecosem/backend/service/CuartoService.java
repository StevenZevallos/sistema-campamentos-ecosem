package com.ecosem.backend.service;

import com.ecosem.backend.entity.Cuarto;
import com.ecosem.backend.repository.CuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuartoService {
    @Autowired
    private CuartoRepository cuartoRepository;

    public List<Cuarto> obtenerTodosLosCuartos() {
        return cuartoRepository.findAll();
    }

    public Cuarto registrarCuarto(Cuarto cuarto) {
        return cuartoRepository.save(cuarto);
    }
}