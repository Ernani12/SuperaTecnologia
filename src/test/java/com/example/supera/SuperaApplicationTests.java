package com.example.supera;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.supera.model.Item;
import com.example.supera.model.Lista;
import com.example.supera.service.ItemService;
import java.util.List;

@SpringBootTest
class SuperaApplicationTests {

    @Autowired
    private ItemService itemService;

    //BDD
    @Test
    public void dadoQueUmItemExiste_quandoEditarDescricao_entaoItemDeveSerAtualizado() {
        // Arrange: Criar e salvar um item
        Item item = new Item();
        item.setDescricao("Descrição Antiga");
        itemService.save(item);

        // Act: Editando a descrição do item
        item.setDescricao("Descrição Nova");
        itemService.save(item);

        // Assert: A descrição do item deve ter sido atualizada
        Item itemAtualizado = itemService.findById(item.getId());
        assertEquals("Descrição Nova", itemAtualizado.getDescricao());
    }

    @Test
    public void dadoQueUmItemExiste_quandoMarcarComoDestaque_entaoItemDeveSerDestaque() {
        // Arrange: Criar e salvar um item
        Item item = new Item();
        item.setDestaque(false);
        itemService.save(item);
    
        // Act: Marcando item como destaque
        item.setDestaque(true);
        itemService.save(item);
    
        // Assert: O item deve ser destaque
        Item itemAtualizado = itemService.findById(item.getId());
        assertTrue(itemAtualizado.isDestaque());
    }



}