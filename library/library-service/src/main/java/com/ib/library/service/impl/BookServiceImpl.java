package com.ib.library.service.impl;

import com.ib.library.model.Book;
import com.ib.library.repository.BookRepository;
import com.ib.library.service.abstraction.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl implements BookService {

  @Autowired
  BookRepository bookRepository;

  @Override
  public Book findBookById(Integer id) {
    return bookRepository.findById(id).get();
  }
}
