package org.gr40in.spring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping()
    public String getBooks(Model model) {

    }


    @PostMapping("create")
    public String createBook(Model model, @RequestParam String name, @RequestParam String author) {

        return "books";
    }
}
