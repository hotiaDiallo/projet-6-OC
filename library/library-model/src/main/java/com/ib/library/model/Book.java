package com.ib.library.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book implements Serializable {

  @Id @GeneratedValue(generator="gen_book", strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name="gen_book", sequenceName="seq_book", allocationSize=1)
  private Integer id;
  private String ISBN;
  private boolean bookStatus;

  public Book() {
  }

  public boolean isBookStatus() {
    return bookStatus;
  }

  public Book(String ISBN, boolean bookStatus) {
    this.bookStatus = bookStatus;
    this.ISBN = ISBN;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public boolean getBookStatus() {
    return bookStatus;
  }

  public void setBookStatus(boolean bookStatus) {
    this.bookStatus = bookStatus;
  }
}
