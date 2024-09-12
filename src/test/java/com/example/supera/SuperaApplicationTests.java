package com.example.supera;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.supera.model.Item;
import com.example.supera.repository.ItemRepository;
import com.example.supera.service.ItemService;


@SpringBootTest
class SuperaApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    private Long testItemId;

    @BeforeEach
    public void setUp() {
        itemRepository.deleteAll();
        Item item = new Item(null, "Item Teste", "Descrição Teste", "PENDENTE", true, true);
        Item savedItem = itemRepository.save(item);
        testItemId = savedItem.getId();
    }

    @Test
    void givenNewItem_whenSaved_thenItShouldBePersisted() {
        Item newItem = new Item(null, "Novo Item", "Descrição", "PENDENTE", true, true);
        Item savedItem = itemService.save(newItem);
        assertNotNull(savedItem.getId());
        assertEquals("Novo Item", savedItem.getTitulo());
    }


    @Test
    void givenItemId_whenSearched_thenCorrectItemShouldBeReturned() {
        Item item = itemService.findById(testItemId);
        assertNotNull(item);
        assertEquals(testItemId, item.getId());
    }

    @Test
    void givenExistingItem_whenUpdated_thenChangesShouldBePersisted() {
        Item item = itemService.findById(testItemId);
        item.setTitulo("Item Atualizado");
        Item updatedItem = itemService.save(item);
        assertEquals("Item Atualizado", updatedItem.getTitulo());
    }

    @Test
    void givenItemId_whenDeleted_thenItemShouldNoLongerExist() {
        itemService.deletarItem(testItemId);
        assertThrows(NoSuchElementException.class, () -> itemService.findById(testItemId));
    }

    @Test
    void whenAllItemsAreRequested_thenTheyShouldBeReturned() {
        List<Item> items = itemService.findAll();
        assertFalse(items.isEmpty());
    }

    @Test
    void givenItemsMarkedAsDestaque_whenSearched_thenOnlyDestaqueItemsShouldBeReturned() {
        List<Item> items = itemService.findByIsDestaqueTrue();
        assertFalse(items.isEmpty());
        assertTrue(items.stream().allMatch(Item::isDestaque));
    }



    @Test
    void givenDestaqueStatus_whenUpdated_thenChangesShouldBeReflected() {
        Item item = itemService.findById(testItemId);
        item.setDestaque(false);
        Item updatedItem = itemService.save(item);
        assertFalse(updatedItem.isDestaque());
    }

 

    @Test
    void whenItemsAreCounted_thenCountShouldBeGreaterThanZero() {
        long count = itemRepository.count();
        assertTrue(count > 0);
    }

}