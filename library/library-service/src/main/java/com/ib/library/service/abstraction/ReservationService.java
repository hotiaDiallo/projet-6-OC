package com.ib.library.service.abstraction;

import com.ib.library.model.Author;

public interface AuthorService {
  public Author findAuthorById(Integer id);
}
