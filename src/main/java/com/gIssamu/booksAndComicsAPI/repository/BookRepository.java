package com.gIssamu.booksAndComicsAPI.repository;

import com.gIssamu.booksAndComicsAPI.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
