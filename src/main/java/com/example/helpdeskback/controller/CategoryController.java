package com.example.helpdeskback.controller;


import com.example.helpdeskback.enums.Category;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/category")
    public Category[] getCategories() {
        return Category.values();
    }
}
