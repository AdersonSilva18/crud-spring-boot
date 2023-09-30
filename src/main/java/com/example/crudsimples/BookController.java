package com.example.crudsimples;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class BookController {

    BookRepository repository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id){
        repository.deleteById(id);
    }
}
