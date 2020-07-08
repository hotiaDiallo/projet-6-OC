package com.ib.library.repository;

import com.ib.library.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}