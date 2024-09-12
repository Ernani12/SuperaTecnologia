package com.example.supera.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String estado; // PENDENTE, CONCLUIDO, CANCELADO
    private Boolean prioridade;
    private boolean isDestaque;



    public Item(Long id, String titulo, boolean isDestaque) {
        this.id = id;
        this.titulo = titulo;
        this.isDestaque = isDestaque;
    }

    public Item() {

    }

    public Item(Long id, String titulo, String descricao, String estado, Boolean prioridade, boolean isDestaque) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.estado = estado;
        this.prioridade = prioridade;
        this.isDestaque = isDestaque;
    }    

    @ManyToOne
    @JoinColumn(name = "lista_id")
    private Lista lista;

    // Getters e Setters

    public Item(String titulo, String descricao, String estado, Boolean prioridade, Lista lista) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.estado = estado;
        this.prioridade = prioridade;
        this.lista = lista;
    }

    public boolean isDestaque() {
        return isDestaque;
    }

    public void setDestaque(boolean isDestaque) {
        this.isDestaque = isDestaque;
    }



    
}