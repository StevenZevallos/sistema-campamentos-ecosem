package com.ecosem.backend.repository;

import com.ecosem.backend.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
    
    // Con extender de JpaRepository, Java ya sabe guardar, buscar, actualizar y eliminar.
    // Más adelante aquí agregaremos reglas personalizadas, como:
    // Optional<Trabajador> findByDni(String dni);
    
}