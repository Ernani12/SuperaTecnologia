
package com.example.supera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supera.DTO.ItemDTO;
import com.example.supera.model.Item;
import com.example.supera.service.ItemService;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String home(){
        return "hello supera itens";
    }

    @PostMapping
    public ResponseEntity<Item> adicionarItem(@RequestBody ItemDTO itemDTO) {
        Item item = itemService.adicionarItem(itemDTO.getListaId(), itemDTO.getTitulo(), itemDTO.getDescricao(), itemDTO.getEstado(), itemDTO.getPrioridade());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItem(@PathVariable Long id) {
        itemService.deletarItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Outros endpoints
}