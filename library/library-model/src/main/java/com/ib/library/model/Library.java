package com.ib.library.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="library")
public class Library {
  @Id @GeneratedValue(generator="gen_library", strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name="gen_library", sequenceName="seq_library", allocationSize=1)
  private Integer id;
  private String name;
  @OneToMany(fetch = FetchType.EAGER)
  private Set<Work> works;

  public Library() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Work> getWorks() {
    return works;
  }

  public void setWorks(Set<Work> works) {
    this.works = works;
  }
}
