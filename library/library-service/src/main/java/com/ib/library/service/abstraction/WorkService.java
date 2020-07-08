package com.ib.library.service.abstraction;

import com.ib.library.model.Author;
import com.ib.library.model.Work;
import java.util.Date;
import java.util.List;

public interface WorkService {
  List<Work> getAllWorks();
  Work findWorkById(Integer id);

  List<Work> findWorkByAuthor(Author author);
  List<Work> findWorkByAuthor_Id(Integer id);
  Work findWorkByAuthorAndReleaseDate(Integer id, Date releaseDate);

  List<Work> findWorkByTitle(String title);
  List<Work> findWorkByReleaseDate(Date releaseDate);

  List<Work> findWorkByAuthorName(String name);

  int getAvailableBooksSize(Work work);
}
