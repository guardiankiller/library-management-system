package com.guardiankiller.library.controller;

import com.guardiankiller.library.models.BookBasicDTO;
import com.guardiankiller.library.models.BookCreateDTO;
import com.guardiankiller.library.models.BookDTO;
import com.guardiankiller.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookDTO addBook(@RequestBody BookCreateDTO bookCreate) {
        return bookService.addBook(bookCreate);
    }

    @GetMapping
    public List<BookBasicDTO> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable long id) {
        var opt = bookService.getBook(id);
        return ResponseEntity.of(opt);
    }
}
