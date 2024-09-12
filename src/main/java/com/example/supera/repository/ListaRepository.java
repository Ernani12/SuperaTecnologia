package com.example.supera.repository;

import com.example.supera.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRepository extends JpaRepository<Lista, Long> {
    // Aqui você pode definir métodos personalizados, se necessário
}