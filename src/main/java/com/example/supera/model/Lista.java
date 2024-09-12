package com.example.supera.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Lista() {
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Lista(String nome) {
        this.nome = nome;
    }

    @OneToMany(mappedBy = "lista", cascade = CascadeType.ALL)
    private List<Item> itens = new ArrayList<>();

    // Getters e Setters
}
