package com.example.project2.repository;


import com.example.project2.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String genreName);
    Genre findByIdAndUserId(Long genreId, Long userId);
    Genre findByUserIdAndName(Long userId, String genreName);
}
