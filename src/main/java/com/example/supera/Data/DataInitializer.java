package com.example.supera.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.supera.model.Item;
import com.example.supera.model.Lista;
import com.example.supera.repository.ItemRepository;
import com.example.supera.repository.ListaRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ListaRepository listaRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void run(String... args) throws Exception {
        // Criando uma nova lista para adicionar os itens
        Lista lista = new Lista();
        lista.setNome("Lista de Eletrodomésticos");
        listaRepository.save(lista);

        // Criando 10 itens de teste com nomes de produtos eletrodomésticos
        Item item1 = new Item();
        item1.setDescricao("Geladeira");
        item1.setDestaque(false);
        item1.setLista(lista);
        itemRepository.save(item1);

        Item item2 = new Item();
        item2.setDescricao("Máquina de Lavar");
        item2.setDestaque(true);
        item2.setLista(lista);
        itemRepository.save(item2);

        Item item3 = new Item();
        item3.setDescricao("Micro-ondas");
        item3.setDestaque(false);
        item3.setLista(lista);
        itemRepository.save(item3);

        Item item4 = new Item();
        item4.setDescricao("Fogão");
        item4.setDestaque(true);
        item4.setLista(lista);
        itemRepository.save(item4);

        Item item5 = new Item();
        item5.setDescricao("Liquidificador");
        item5.setDestaque(false);
        item5.setLista(lista);
        itemRepository.save(item5);

        Item item6 = new Item();
        item6.setDescricao("Aspirador de Pó");
        item6.setDestaque(true);
        item6.setLista(lista);
        itemRepository.save(item6);

        Item item7 = new Item();
        item7.setDescricao("Cafeteira");
        item7.setDestaque(false);
        item7.setLista(lista);
        itemRepository.save(item7);

        Item item8 = new Item();
        item8.setDescricao("Ar-Condicionado");
        item8.setDestaque(true);
        item8.setLista(lista);
        itemRepository.save(item8);

        Item item9 = new Item();
        item9.setDescricao("Ferro de Passar");
        item9.setDestaque(false);
        item9.setLista(lista);
        itemRepository.save(item9);

        Item item10 = new Item();
        item10.setDescricao("Batedeira");
        item10.setDestaque(true);
        item10.setLista(lista);
        itemRepository.save(item10);
    }
}
