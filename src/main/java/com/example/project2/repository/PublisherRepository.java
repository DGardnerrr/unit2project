package com.example.project2.repository;



import com.example.project2.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByName(String publisherName);
    List<Publisher> findByUserId(Long userId);
    Optional<Publisher> findByIdAndUserId(Long publisherId, Long userId);
}
