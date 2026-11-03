package com.ecosem.backend.repository;

import com.ecosem.backend.entity.Cama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamaRepository extends JpaRepository<Cama, Long> {
    
}