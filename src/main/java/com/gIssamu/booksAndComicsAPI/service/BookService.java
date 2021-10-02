package com.gIssamu.booksAndComicsAPI.service;

import java.util.List;
import java.util.stream.Collectors;

import com.gIssamu.booksAndComicsAPI.dto.request.BookDTO;
import com.gIssamu.booksAndComicsAPI.dto.response.MessageResponseDTO;
import com.gIssamu.booksAndComicsAPI.entity.Book;
import com.gIssamu.booksAndComicsAPI.expection.BookNotFoundException;
import com.gIssamu.booksAndComicsAPI.mapper.BookMapper;
import com.gIssamu.booksAndComicsAPI.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {
    
    private BookRepository bookRepository; 

    private final BookMapper bookMapper = BookMapper.INSTANCE; 


    public MessageResponseDTO createBook(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO); 
        Book savedBook = bookRepository.save(bookToSave); 

        return createMessageResponse(savedBook.getId(), "Created Book with ID "); 
    }

    public List<BookDTO> listAll() {
        List<Book> allBooks = bookRepository.findAll(); 

        return allBooks.stream()
            .map(bookMapper::toDTO)
            .collect(Collectors.toList()); 
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = verifyIfExists(id);

        return bookMapper.toDTO(book); 
    }

    public void deleteById(Long id) throws BookNotFoundException {
        verifyIfExists(id);

        bookRepository.deleteById(id); 
    }

    public MessageResponseDTO updateById(Long id, BookDTO bookDTO) throws BookNotFoundException {
        verifyIfExists(id);

        Book bookToUpdate = bookMapper.toModel(bookDTO); 
        Book updatedBook = bookRepository.save(bookToUpdate); 

        return createMessageResponse(updatedBook.getId(), "Updated Book with ID ");
    }

    private Book verifyIfExists(Long id) throws BookNotFoundException {
        return bookRepository.findById(id)
            .orElseThrow(() -> new BookNotFoundException(id)); 

    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
            .builder()
            .message(message + id)
            .build(); 
    }

}