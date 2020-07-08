package com.ib.library.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "work")
public class Work implements Serializable {
  @Id @GeneratedValue(generator="gen_work", strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name="gen_work", sequenceName="seq_work", allocationSize=1)
  private Integer id;
  @ManyToOne(fetch = FetchType.EAGER)
  private Author author;
  private String title;
  private String summary;
  private Date releaseDate;
  @OneToMany(fetch = FetchType.EAGER)
  private List<Book> books;
  @ManyToOne(fetch = FetchType.EAGER)
  private Library library;

  public Work() {
  }

  public Work(String title, Date releaseDate, String summary) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.summary = summary;
  }

  public boolean isLoanable(){
    boolean status = false;
    for(Book book : books){
      if(book.getBookStatus()==true){
        status = true;
        break;
      }else{
        continue;
      }
    }
    return status;
  }

  public int getAvailableBooksSize(){
    int result=0;
    for(Book book : books){
      if(book.getBookStatus()==true){
        result++;
      }else{
        continue;
      }
    }
    return result;
  }

  public Book getAvailableBook(List<Book> books){
    Book newBook = null;
    for(Book book : books){
      if(book.getBookStatus()){
        newBook = book;
        break;
      }else {
        continue;
      }
    }
    return newBook;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  public Library getLibrary() {
    return library;
  }

  public void setLibrary(Library library) {
    this.library = library;
  }
}
