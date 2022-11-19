package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.entities.Item;
import edu.attractor.kg.m9.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemControllers {
    private final ItemService itemService;

    @GetMapping("/getItems")
    public String getItems(){
    return "";
    }


    @GetMapping("/searchItems")
    public ResponseEntity<List<Item>> searchItems(@RequestParam String item, @RequestParam int page){
        return new  ResponseEntity<>(itemService.searchItem(item, page).getContent(), HttpStatus.OK);
    }



}
