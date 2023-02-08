package com.guardiankiller.library.repository;

import com.guardiankiller.library.entity.Book;
import com.guardiankiller.library.models.BookBasicDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("""
    SELECT NEW com.guardiankiller.library.models.BookBasicDTO (
        b.id, b.title, b.description
    )
    FROM Book b
    """)
    List<BookBasicDTO> getBooks();
}
