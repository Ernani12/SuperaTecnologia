package com.example.supera.service;

import com.example.supera.model.Item;
import com.example.supera.model.Lista;
import com.example.supera.repository.ItemRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> findByLista(Lista lista) {
        return itemRepository.findByLista(lista);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    public Item findById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

   
}
