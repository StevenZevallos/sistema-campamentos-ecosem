package com.ecosem.backend.repository;

import com.ecosem.backend.entity.Cuarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuartoRepository extends JpaRepository<Cuarto, Long> {
    
}