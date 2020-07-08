package com.ib.library.service.impl;

import com.ib.library.model.Author;
import com.ib.library.model.Book;
import com.ib.library.model.Work;
import com.ib.library.repository.WorkRepository;
import com.ib.library.service.abstraction.WorkService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {

  @Autowired
  private WorkRepository workRepository;

  @Override
  public List<Work> getAllWorks() {
    return (List<Work>) workRepository.findAll();
  }

  @Override
  public Work findWorkById(Integer id) {
    return workRepository.findById(id).get();
  }

  @Override
  public Work findWorkByAuthorAndReleaseDate(Integer id, Date releaseDate) {
    return workRepository.findWorkByAuthor_IdAndReleaseDate(id, releaseDate);
  }

  @Override
  public List<Work> findWorkByAuthor(Author author) {
    List<Work> works = workRepository.findWorkByAuthor(author);
    return works;
  }

  @Override
  public List<Work> findWorkByAuthor_Id(Integer id) {
    List<Work> works = workRepository.findWorkByAuthor_Id(id);
    return works;
  }

  @Override
  public List<Work> findWorkByTitle(String title) {
    List<Work> works = workRepository.findWorkByTitleContainingIgnoreCase(title);
    return works;
  }

  @Override
  public List<Work> findWorkByReleaseDate(Date releaseDate) {
    List<Work> works = workRepository.findWorkByReleaseDate(releaseDate);
    return works;
  }

  @Override
  public List<Work> findWorkByAuthorName(String name) {
    return workRepository.findWorkByAuthor_FullNameContainingIgnoreCase(name);
  }

  @Override
  public int getAvailableBooksSize(Work work) {
    int result=0;
    for(Book book : work.getBooks()){
      if(book.getBookStatus()==true){
        result++;
      }else{
        continue;
      }
    }
    return result;
  }

}
