package com.gIssamu.booksAndComicsAPI.controller;

import java.util.List;

import javax.validation.Valid;

import com.gIssamu.booksAndComicsAPI.dto.request.BookDTO;
import com.gIssamu.booksAndComicsAPI.dto.response.MessageResponseDTO;
import com.gIssamu.booksAndComicsAPI.expection.BookNotFoundException;
import com.gIssamu.booksAndComicsAPI.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/book") 
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {
    
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createBook(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.createBook(bookDTO); 
    }

    @GetMapping
    public List<BookDTO> listAll() {
        return bookService.listAll(); 
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable("id") Long id) throws BookNotFoundException {
        return bookService.findById(id); 
    }

    @PutMapping("{id}")
    public MessageResponseDTO updateById(@PathVariable("id") Long id, @RequestBody BookDTO bookDTO) throws BookNotFoundException {
        return bookService.updateById(id, bookDTO); 
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") Long id) throws BookNotFoundException {
        bookService.deleteById(id); 
    }
}
