package com.gIssamu.booksAndComicsAPI.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.gIssamu.booksAndComicsAPI.enums.BookType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

    @Column(nullable = false) 
    private String name; 

    @Column(nullable = false)
    private BookType type; 

    @Column(nullable = false) 
    private String edition; 

    @Column(nullable = false) 
    private String publisher;

    @Column(nullable = false)
    private String numberPages; 

    private LocalDate publicationDate; 

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Author> authors; 
}
