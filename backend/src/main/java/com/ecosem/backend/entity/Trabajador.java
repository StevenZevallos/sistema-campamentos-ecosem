package com.ecosem.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trabajador")
public class Trabajador {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 8)
    private String dni;

    @Column(nullable = false, length = 100)
    private String nombres;

    @Column(nullable = false, length = 100)
    private String apellidos;

    @Column(nullable = false, length = 100)
    private String cargo; // Ej: Auxiliar, Asistente, Practicante

    @Column(nullable = false, length = 100)
    private String area; // Ej: TIC, Recursos Humanos, Mantenimiento

    @Column(name = "empresa_contratista", length = 100)
    private String empresaContratista;
}