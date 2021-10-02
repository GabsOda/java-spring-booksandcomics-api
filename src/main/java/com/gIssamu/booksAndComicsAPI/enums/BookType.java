package com.gIssamu.booksAndComicsAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookType {
    
    BOOK("Book"),
    COMIC("Comic"),
    MANGA("Manga"); 

    private final String description; 

}
