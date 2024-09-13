package com.example.supera.controller;

import com.example.supera.model.Lista;
import com.example.supera.service.ListaService;
import com.example.supera.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @Autowired
    private ItemService itemService;

    @GetMapping
    public String listarListas(Model model) {
        model.addAttribute("listas", listaService.findAll());
        return "listar-listas";
    }

    @GetMapping("/{id}")
    public String detalhesLista(@PathVariable Long id, Model model) {
        Lista lista = listaService.findById(id);
        model.addAttribute("lista", lista);
        model.addAttribute("itens", itemService.findByLista(lista));
        return "detalhes-lista";
    }

    @GetMapping("/novo")
    public String adicionarLista(Model model) {
        model.addAttribute("lista", new Lista());
        return "adicionar-lista";
    }

    @PostMapping
    public String salvarLista(@ModelAttribute Lista lista) {
        listaService.save(lista);
        return "redirect:/listas";
    }

    @GetMapping("/editar/{id}")
    public String editarLista(@PathVariable Long id, Model model) {
        Lista lista = listaService.findById(id);
        model.addAttribute("lista", lista);
        return "editar-lista";
    }

    @PostMapping("/editar/{id}")
    public String atualizarLista(@PathVariable Long id, @ModelAttribute Lista lista) {
        lista.setId(id);
        listaService.save(lista);
        return "redirect:/listas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarLista(@PathVariable Long id) {
        listaService.delete(id);
        return "redirect:/listas";
    }
}
