package com.guardiankiller.library.service.impl;

import com.guardiankiller.library.entity.Book;
import com.guardiankiller.library.models.BookBasicDTO;
import com.guardiankiller.library.models.BookCreateDTO;
import com.guardiankiller.library.models.BookDTO;
import com.guardiankiller.library.repository.BookRepository;
import com.guardiankiller.library.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDTO addBook(BookCreateDTO bookCreate) {
        var book = new Book();
        book.setPublisher(bookCreate.getPublisher());
        book.setTitle(bookCreate.getTitle());
        book.setAuthor(bookCreate.getAuthor());
        book.setDescription(bookCreate.getDescription());
        book.setReleaseDate(bookCreate.getReleaseDate());
        book.setISBN(bookCreate.getISBN());

        var newBook = bookRepository.save(book);

        return toDTO(newBook);
    }

    @Override
    public List<BookBasicDTO> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public Optional<BookDTO> getBook(long id) {
        return bookRepository
            .findById(id)
            .map(this::toDTO);
    }

    @Override
    public Optional<BookDTO> editBook(long id, BookCreateDTO bookCreate) {
        var opt = bookRepository.findById(id);
        if(opt.isEmpty()) {
            return Optional.empty();
        }
        var book = opt.get();

        if(bookCreate.getAuthor() != null) {
            book.setAuthor(bookCreate.getAuthor());
        }

        if(bookCreate.getDescription() != null) {
            book.setDescription(bookCreate.getDescription());
        }

        if(bookCreate.getISBN() != null) {
            book.setISBN(bookCreate.getISBN());
        }

        if(bookCreate.getTitle() != null) {
            book.setTitle(bookCreate.getTitle());
        }

        if(bookCreate.getReleaseDate() != null) {
            book.setReleaseDate(bookCreate.getReleaseDate());
        }

        if(bookCreate.getPublisher() != null) {
            book.setPublisher(bookCreate.getPublisher());
        }

        bookRepository.save(book);

        return Optional.of(toDTO(book));
    }

    @Override
    public boolean deleteBook(long id) {
        var opt = bookRepository.findById(id);
        if(opt.isEmpty()) {
            return false;
        }
        var book = opt.get();
        bookRepository.delete(book);
        return true;
    }

    private BookDTO toDTO(Book newBook) {
        var dto = new BookDTO();
        dto.setPublisher(newBook.getPublisher());
        dto.setTitle(newBook.getTitle());
        dto.setAuthor(newBook.getAuthor());
        dto.setDescription(newBook.getDescription());
        dto.setReleaseDate(newBook.getReleaseDate());
        dto.setISBN(newBook.getISBN());
        dto.setId(newBook.getId());
        return dto;
    }
}
