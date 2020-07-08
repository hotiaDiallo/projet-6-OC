package com.ib.library.repository;

import com.ib.library.model.Library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Library, Integer> {

}
