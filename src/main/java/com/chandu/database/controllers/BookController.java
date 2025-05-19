package com.chandu.database.controllers;

import com.chandu.database.domain.dto.BookDto;
import com.chandu.database.domain.entities.BookEntity;
import com.chandu.database.mappers.Mapper;
import com.chandu.database.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private Mapper<BookEntity,BookDto> mapper;

    private BookService bookService;

    public BookController(Mapper<BookEntity, BookDto> mapper,BookService bookService) {
        this.mapper = mapper;
        this.bookService=bookService;
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> createBook(@PathVariable("isbn") String isbn, @RequestBody BookDto bookDto){
        BookEntity bookEntity=mapper.mapFrom(bookDto);
        BookEntity res=bookService.createBook(isbn,bookEntity);
        return new ResponseEntity<>(mapper.mapTo(res),HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public List<BookDto> findAllBooks(){
        List<BookEntity> books=bookService.findAll();
        return books.stream().map(mapper::mapTo).collect(Collectors.toList());
    }
}
