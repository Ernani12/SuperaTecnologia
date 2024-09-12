package com.example.supera.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private Long id;
    private String titulo;
    private boolean destaque;
    private Long listaId;
    private String descricao;
    private String estado; // PENDENTE, CONCLUIDO, CANCELADO
    private Boolean prioridade;

    // Construtores
    public ItemDTO() {
    }

    public ItemDTO(Long id, String titulo, boolean destaque, Long listaId) {
        this.id = id;
        this.titulo = titulo;
        this.destaque = destaque;
        this.listaId = listaId;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }

    public Long getListaId() {
        return listaId;
    }

    public void setListaId(Long listaId) {
        this.listaId = listaId;
    }
}
