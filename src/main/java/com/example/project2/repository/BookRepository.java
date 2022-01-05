package com.example.project2.repository;

import com.example.project2.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public class BookRepository extends JpaRepository<Book, Long> {
    Book findByName(String bookName) {
        return null;
    }
}
