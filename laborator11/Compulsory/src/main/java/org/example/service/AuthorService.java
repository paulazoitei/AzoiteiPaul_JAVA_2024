package org.example.service;

import org.example.model.Author;
import org.example.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id).orElse(null);
    }

    public Author getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }
}