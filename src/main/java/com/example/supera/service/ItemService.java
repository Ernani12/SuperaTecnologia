package com.example.supera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supera.model.Item;
import com.example.supera.model.Lista;
import com.example.supera.repository.ItemRepository;
import com.example.supera.repository.ListaRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ListaRepository listaRepository;

    public Item adicionarItem(Long listaId, String titulo, String descricao, String estado, Boolean prioridade) {
        Lista lista = listaRepository.findById(listaId).orElseThrow(() -> new RuntimeException("Lista não encontrada"));
        Item item = new Item();
        item.setTitulo(titulo);
        item.setDescricao(descricao);
        item.setEstado(estado);
        item.setPrioridade(prioridade);
        item.setLista(lista);
        return itemRepository.save(item);
    }

    public void deletarItem(Long id) {
        itemRepository.deleteById(id);
    }

    // Métodos adicionais de serviço
}
