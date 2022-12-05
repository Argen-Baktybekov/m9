package edu.attractor.kg.m9.controllers;

import edu.attractor.kg.m9.entities.Item;
import edu.attractor.kg.m9.entities.Review;
import edu.attractor.kg.m9.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemControllers {
    private final ItemService itemService;

    @GetMapping(value = "/")
    public String getAllItems(Model model) {
        model.addAttribute("items", itemService.getItemPageSortedAscPrice().getContent());
        return "index";
    }

    @GetMapping(value = "/item")
    public String getItems(Model model) {
        model.addAttribute("items", itemService.getItemPageSortedAscPrice().getContent());
        return "index";
    }

    @GetMapping("item/searchItems")
    public ResponseEntity<List<Item>> searchItems(@RequestParam String item,
                                                  @RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(itemService.searchItem(item, page, size).getContent(), HttpStatus.OK);
    }

    @PostMapping("/item/review")
    public String addReview(@RequestParam String review, @RequestParam Long itemId,
                          Authentication authentication){
        itemService.addReview(itemId, review, authentication.getName());
        return "redirect:/customer/profile";
    }

    @GetMapping("/item/review")
    public ResponseEntity<List<Review>> addReview(@RequestParam Long itemId){
       return new ResponseEntity<>(itemService.getReviews(itemId), HttpStatus.OK);
    }
}
