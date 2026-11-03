package com.ecosem.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cuarto")
public class Cuarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String numero; // Ej: 101, 102A

    @Column(length = 100)
    private String descripcion; // Ej: Cuarto para personal de mantenimiento
}