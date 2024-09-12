package com.example.supera.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.supera.model.Item;
import com.example.supera.model.Lista;
import com.example.supera.repository.ItemRepository;
import com.example.supera.repository.ListaRepository;
import org.springframework.data.domain.Sort;



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

   public Item findById(Long id) {
        return itemRepository.findById(id)
                             .orElseThrow(() -> new NoSuchElementException("Item not found with id: " + id));
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

      // Método para buscar todos os itens com ordenação
    public List<Item> findAll(Sort sort) {
        return itemRepository.findAll(sort);
    }

    public List<Item> findByIsDestaqueTrue() {
        return itemRepository.findByIsDestaqueTrue();
    }


}
