package com.gIssamu.booksAndComicsAPI.mapper;

import com.gIssamu.booksAndComicsAPI.dto.request.BookDTO;
import com.gIssamu.booksAndComicsAPI.entity.Book;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class); 

    @Mapping(target = "publicationDate", source = "publicationDate", dateFormat = "dd-MM-yyyy")
    Book toModel(BookDTO bookDTO); 

    BookDTO toDTO(Book book); 

}
