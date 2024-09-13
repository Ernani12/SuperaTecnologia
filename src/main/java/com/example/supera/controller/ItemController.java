package com.example.supera.controller;

import com.example.supera.model.Item;
import com.example.supera.model.Lista;
import com.example.supera.service.ItemService;
import com.example.supera.service.ListaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ListaService listaService;

    @GetMapping("/novo/{listaId}")
    public String adicionarItem(@PathVariable Long listaId, Model model) {
        Lista lista = listaService.findById(listaId);
        Item item = new Item();
        item.setLista(lista);
        model.addAttribute("item", item);
        return "adicionar-item";
    }

    @PostMapping
    public String salvarItem(@ModelAttribute Item item) {
        itemService.save(item);
        return "redirect:/listas/" + item.getLista().getId();
    }

    @GetMapping("/editar/{id}")
    public String editarItem(@PathVariable Long id, Model model) {
        Item item = itemService.findById(id);
        model.addAttribute("item", item);
        return "editar-item";
    }

    @PostMapping("/editar/{id}")
    public String atualizarItem(@PathVariable Long id, @ModelAttribute Item itemAtualizado) {
        Item itemExistente = itemService.findById(id);

    
        if (itemExistente != null) {
            itemExistente.setDescricao(itemAtualizado.getDescricao());
            itemExistente.setDestaque(itemAtualizado.isDestaque()); // Atualizando o campo "destaque"
            itemService.save(itemExistente);
        } 
    
        return "redirect:/listas/" + itemExistente.getLista().getId();
    }
    
     

    @GetMapping("/deletar/{id}")
    public String deletarItem(@PathVariable Long id) {
        Item item = itemService.findById(id);
        itemService.delete(id);
        return "redirect:/listas/" + item.getLista().getId();
    }
}
