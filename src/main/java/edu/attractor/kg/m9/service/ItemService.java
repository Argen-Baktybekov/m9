package edu.attractor.kg.m9.service;

import edu.attractor.kg.m9.entities.Category;
import edu.attractor.kg.m9.entities.Item;
import edu.attractor.kg.m9.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

public List<Item> getAll(){
    int page = 0;
    int count = 10;
    Sort sortBy = Sort.by(Sort.Order.asc("price"));
    Pageable pageable = PageRequest.of(page, count, sortBy);
   return itemRepository.findAllBy(pageable).getContent();
}
    public Page<Item> getItemPageSortedAscPrice(){
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

public Page<Item> searchItem(String search, int page, int size){
    Sort sortBy = Sort.by(Sort.Order.asc("price"));
    Pageable pageable = PageRequest.of(page, size, sortBy);
    Page<Item> pageResult =itemRepository.findItemByNameIgnoreCaseOrDescriptionContains(search, search,pageable);
    return pageResult;
}

//        @Bean
        public void print (){
        System.out.println(getItemPageSortedAscPrice().getContent());
        changeDescription();
        itemRepository.changePrice(9.0,1l);
        System.out.println(getItemPageSortedAscPrice().getContent());
            System.out.println(itemRepository.findAllByCategoryOrderById(Category.FLOWERS.toString()));
//            System.out.println(itemRepository.findItemByNameIgnoreCaseOrDescriptionContains("rose", "rose"));
            System.out.println(itemRepository.getItemsByMaxPrice(10.0));

        }

    public Item getItemById(Long itemId) {
    Optional<Item> item =  itemRepository.findById(itemId);
    if (item.isEmpty()){
        return null;
    }
    return item.get();
    }
}
