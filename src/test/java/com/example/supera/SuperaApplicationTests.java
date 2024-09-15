package com.example.supera;



import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.supera.model.Item;
import com.example.supera.model.Lista;
import com.example.supera.repository.ItemRepository;
import com.example.supera.repository.ListaRepository;
import com.example.supera.service.ItemService;
import com.example.supera.service.ListaService;



@SpringBootTest
class SuperaApplicationTests {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ListaService listaService;

    @MockBean
    private ItemRepository itemRepository;

    @MockBean
    private ListaRepository listaRepository;

   
    @Test
    public void testSaveItem() {
        // Given
        Item item = new Item();
        item.setDescricao("Item para Teste");
        item.setDestaque(false);

        // Define o comportamento do mock para retornar o item ao salvar
        when(itemRepository.save(any(Item.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        Item savedItem = itemService.save(item);

        // Then
        assertNotNull(savedItem);
        assertEquals("Item para Teste", savedItem.getDescricao());
        assertFalse(savedItem.isDestaque());
    }


    @Test
    public void givenList_whenUpdateList_thenListShouldBeUpdated() {
        // Given
        Lista lista = new Lista();
        lista.setNome("Lista Antiga");
    
        // Configura o mock para retornar a lista com um ID fixo
        when(listaRepository.save(any(Lista.class))).thenAnswer(invocation -> {
            Lista listaToSave = invocation.getArgument(0);
            listaToSave.setId(1L); // Define um ID fixo para simular a lista salva
            return listaToSave;
        });
    
        // Configura o mock para retornar a lista salva ao buscar pelo ID
        when(listaRepository.findById(1L)).thenReturn(Optional.of(lista));
    
        // Salva a lista
        Lista savedLista = listaService.save(lista);
        assertNotNull(savedLista);
        assertEquals("Lista Antiga", savedLista.getNome());
    
        // When
        savedLista.setNome("Lista Atualizada");
        listaService.save(savedLista);
    
        // Configura o mock para retornar a lista atualizada ao buscar pelo ID
        when(listaRepository.findById(1L)).thenReturn(Optional.of(savedLista));
    
        // Then
        Lista updatedLista = listaService.findById(1L);
        assertNotNull(updatedLista);
        assertEquals("Lista Atualizada", updatedLista.getNome());
    }
    
   
    
    @Test
    public void testRemoveItem() {
        // Given
        Item item = new Item();
        item.setDescricao("Item para Remover");
        itemService.save(item);
    
        // When
        itemService.delete(item.getId());
    
        // Then
        Item deletedItem = itemService.findById(item.getId());
        assertNull(deletedItem);
    }

    
    @Test
    public void testFindByIdLista() {
        // Dado uma lista salva no repositório
        Lista lista = new Lista();
        lista.setNome("Lista Existente");
        lista.setId(1L); // Define um ID fixo para simular a lista salva

        // Configura o mock para retornar a lista ao buscar pelo ID
        when(listaRepository.findById(1L)).thenReturn(Optional.of(lista));

        // Quando buscar a lista pelo ID
        Lista foundLista = listaService.findById(1L);

        // Então a lista encontrada não deve ser nula
        assertNotNull(foundLista);
        assertEquals("Lista Existente", foundLista.getNome());
    }


    @Test
    public void testSaveLista() {
        // Dado uma nova lista
        Lista lista = new Lista();
        lista.setNome("Nova Lista");

        // Configura o mock para retornar a lista salva
        when(listaRepository.save(any(Lista.class))).thenAnswer(invocation -> {
            Lista savedLista = invocation.getArgument(0);
            savedLista.setId(1L); // Define um ID fixo para simular a lista salva
            return savedLista;
        });

        // Quando salvar a lista
        Lista savedLista = listaService.save(lista);

        // Então a lista salva deve ter um ID atribuído
        assertNotNull(savedLista.getId());
    }

    @Test
    public void testDeleteLista() {
        // Dado uma lista salva no repositório
        Lista lista = new Lista();
        lista.setNome("Lista para Deletar");

        // Configura o comportamento do mock para retornar a lista ao salvar
        when(listaRepository.save(any(Lista.class))).thenAnswer(invocation -> {
            Lista listaToSave = invocation.getArgument(0);
            listaToSave.setId(1L); // Define um ID fixo para simular a lista salva
            return listaToSave;
        });

        // Salva a lista e verifica se ela foi salva com um ID
        Lista savedLista = listaService.save(lista);
        assertNotNull(savedLista); // Garante que a lista foi salva
        assertNotNull(savedLista.getId()); // Garante que a lista tem um ID

        // Configura o comportamento do mock para encontrar a lista pelo ID
        when(listaRepository.findById(savedLista.getId())).thenReturn(Optional.of(savedLista));

        // Quando deletar a lista pelo ID
        listaService.delete(savedLista.getId());

        // Configura o comportamento do mock para retornar um Optional vazio ao buscar a lista deletada
        when(listaRepository.findById(savedLista.getId())).thenReturn(Optional.empty());

        // Então a lista não deve ser encontrada
        assertThrows(RuntimeException.class, () -> listaService.findById(savedLista.getId()));
    }


    @Test
    public void testFindById_ItemNaoExistente() {
        // Dado um ID que não existe no repositório
        Long idNaoExistente = 999L;

        // Quando buscar o item pelo ID
        Item foundItem = itemService.findById(idNaoExistente);

        // Então o item encontrado deve ser nulo
        assertNull(foundItem);
    }

    @Test
    public void testDelete_ItemNaoExistente() {
        // Dado um ID que não existe no repositório
        Long idNaoExistente = 999L;

        // Quando tentar deletar o item
        // Então não deve lançar nenhuma exceção
        assertDoesNotThrow(() -> itemService.delete(idNaoExistente));
    }

    @Test
    public void testSaveItemWithDestaque() {
        // Dado um novo item com destaque marcado
        Item item = new Item();
        item.setDescricao("Item em Destaque");
        item.setDestaque(true);

        // Define o comportamento do mock para retornar o item ao salvar
        when(itemRepository.save(any(Item.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Quando salvar o item
        Item savedItem = itemService.save(item);

        // Então o item salvo deve ter o atributo destaque como verdadeiro
        assertNotNull(savedItem);
        assertTrue(savedItem.isDestaque());
    }

   


}