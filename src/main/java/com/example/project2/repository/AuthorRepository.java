package com.example.project2.repository;

import com.example.project2.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorRepository  extends JpaRepository<Author,Long> {
    Author findByName(String authorName);
}



