package com.guardiankiller.library.service;

import com.guardiankiller.library.models.BookBasicDTO;
import com.guardiankiller.library.models.BookCreateDTO;
import com.guardiankiller.library.models.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {

    BookDTO addBook(BookCreateDTO bookCreate);

    List<BookBasicDTO> getBooks();

    Optional<BookDTO> getBook(long id);
}
