package com.example.supera.repository;

import com.example.supera.model.Item;


import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByListaId(Long listaId);
    
    List<Item> findByIsDestaqueTrue();


}