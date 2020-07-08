package com.ib.library.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author implements Serializable {
  @Id @GeneratedValue(generator="gen_author", strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name="gen_author", sequenceName="seq_author", allocationSize=1)
  private Integer id;
  private String fullName;

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  private String firstName;
  private String lastName;

  @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
  private Set<Work> works;

  public Set<Work> getWorks() {
    return works;
  }

  public void setWorks(Set<Work> works) {
    this.works = works;
  }

  public Author() {
  }

  public Author(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Author author = (Author) o;
    return firstName.equals(author.firstName) &&
        lastName.equals(author.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


}
