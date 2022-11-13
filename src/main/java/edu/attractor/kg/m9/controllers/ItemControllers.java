package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemControllers {
    private final ItemService itemService;

    @GetMapping("/getItems")
    public String getItems(){
    return "";
    }
}
