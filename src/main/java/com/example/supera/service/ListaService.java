package com.example.supera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supera.model.Lista;
import com.example.supera.repository.ListaRepository;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public Lista criarLista(String nome) {
        Lista lista = new Lista();
        lista.setNome(nome);
        return listaRepository.save(lista);
    }

    public void deletarLista(Long id) {
        listaRepository.deleteById(id);
    }

    // Métodos adicionais de serviço
}