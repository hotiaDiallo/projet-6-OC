package com.ib.library.service.impl;

import com.ib.library.model.Author;
import com.ib.library.repository.AuthorRepository;
import com.ib.library.service.abstraction.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

  @Autowired
  AuthorRepository authorRepository;

  @Override
  public Author findAuthorById(Integer id) {
    return authorRepository.findById(id).get();
  }
}
