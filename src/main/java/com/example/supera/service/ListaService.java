package com.example.supera.service;

import com.example.supera.model.Lista;
import com.example.supera.repository.ListaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public List<Lista> findAll() {
        return listaRepository.findAll();
    }

    public Lista findById(Long id) {
        return listaRepository.findById(id).orElseThrow(() -> new RuntimeException("Lista não encontrada"));
    }

    public Lista save(Lista lista) {
        return listaRepository.save(lista);
    }

    public void delete(Long id) {
        listaRepository.deleteById(id);
    }
}
