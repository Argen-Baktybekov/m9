package edu.attractor.kg.m9.service;

import edu.attractor.kg.m9.entities.Item;
import edu.attractor.kg.m9.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;


    private Page<Item> getItemPageSortedAscPrice(){
        int page = 0;
        int count = 10;
        Sort sortBy = Sort.by(Sort.Order.asc("price"));
        Pageable pageable = PageRequest.of(page, count, sortBy);
        Page<Item> pageResult =itemRepository.findAllBy(pageable);
        return pageResult;
    }

public void changeDescription(){
        String newDescription = "hello World";
        long id = 1;
        itemRepository.changeDescription(newDescription, id);
}

//        @Bean
        public void print (){
        System.out.println(getItemPageSortedAscPrice().getContent());
        changeDescription();
        itemRepository.changePrice(9.0,1l);
        System.out.println(getItemPageSortedAscPrice().getContent());
            System.out.println(itemRepository.findAllByCategoryOrderById("flowers"));
            System.out.println(itemRepository.findItemByNameIgnoreCaseOrDescriptionContains("rose", "rose"));
            System.out.println(itemRepository.getItemsByMaxPrice(10.0));

        }
}
