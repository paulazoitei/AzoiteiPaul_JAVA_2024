//package org.example.controller;
//
//import org.example.model.Author;
//import org.example.repository.AuthorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/authors")
//public class AuthorController {
//
//    @Autowired
//    private AuthorRepository authorRepository;
//
//    @GetMapping
//    public List<Author> getAllAuthors() {
//        return authorRepository.findAll();
//    }
//
//    @PostMapping
//    public Author createAuthor(@RequestBody Author author) {
//        return authorRepository.save(author);
//    }
//
//    @GetMapping("/{id}")
//    public Author getAuthorById(@PathVariable Integer id) {
//        return authorRepository.findById(id).orElse(null);
//    }
//
//    @GetMapping("/findByName")
//    public Author getAuthorByName(@RequestParam String name) {
//        return authorRepository.findByName(name);
//    }
//}

package org.example.controller;

import org.example.model.Author;
import org.example.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }
}

