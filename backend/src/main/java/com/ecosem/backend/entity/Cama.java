package com.ecosem.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cama")
public class Cama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cama", nullable = false, length = 10)
    private String numeroCama; // Ej: A, B, C (o 1, 2, 3)

    @Column(nullable = false, length = 20)
    private String estado; // Ej: LIBRE, OCUPADA, LIMPIEZA

    // --- AQUÍ ESTÁ LA RELACIÓN ---
    // @ManyToOne significa: "Muchas (Many) Camas pertenecen a Un (One) Cuarto"
    @ManyToOne
    @JoinColumn(name = "cuarto_id", nullable = false)
    private Cuarto cuarto; 
}