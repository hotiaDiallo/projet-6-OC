package com.ib.library.repository;

import com.ib.library.model.Author;
import com.ib.library.model.Work;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface WorkRepository extends CrudRepository<Work, Integer> {
  List<Work> findWorkByTitleContainingIgnoreCase(String title);
  List<Work> findWorkByReleaseDate(Date releaseDate);
  List<Work> findWorkByAuthor(Author author);
  Work findWorkByAuthor_IdAndReleaseDate(Integer id, Date releaseDate);
  List<Work> findWorkByAuthor_Id(Integer id);

  List<Work> findWorkByAuthor_FullNameContainingIgnoreCase(String name);
}
