package com.chandu.database.services;

import com.chandu.database.domain.entities.BookEntity;

import java.awt.print.Book;
import java.util.List;

public interface BookService {

    BookEntity createBook(String isbn, BookEntity book);

    List<BookEntity> findAll();
}
