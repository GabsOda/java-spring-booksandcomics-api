package com.gIssamu.booksAndComicsAPI.dto.request;

import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.gIssamu.booksAndComicsAPI.enums.BookType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    
    private Long id; 

    @NotEmpty
    private String name; 
    
    @Enumerated(EnumType.STRING)
    private BookType type; 

    @NotEmpty
    private String edition; 

    @NotEmpty
    private String publisher;

    @NotEmpty
    private String numberPages; 

    private String publicationDate; 

    @Valid
    @NotEmpty
    private List<AuthorDTO> authors; 
}
