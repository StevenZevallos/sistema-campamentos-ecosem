package com.ecosem.backend.service;

import com.ecosem.backend.entity.Cama;
import com.ecosem.backend.repository.CamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamaService {
    @Autowired
    private CamaRepository camaRepository;

    public List<Cama> obtenerTodasLasCamas() {
        return camaRepository.findAll();
    }

    public Cama registrarCama(Cama cama) {
        return camaRepository.save(cama);
    }
}