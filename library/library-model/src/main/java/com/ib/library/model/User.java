package com.ib.library.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User implements Serializable {
  @Id @GeneratedValue(generator="gen_user", strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name="gen_user", sequenceName="seq_user", allocationSize=1)
  private Integer id;
  private String firstName;
  private String lastName;
  @Column(nullable = true)
  private Date birthDate;
  @Column(nullable = true)
  private String localAdress;
  @Column(nullable = true)
  private Integer postalCode;
  @Column(nullable = true)
  private String city;
  @Column(nullable = true)
  private String phoneNumber;
  private String email;
  private String password;

  public User() {
  }

  public User(String firstName, String lastName, Date birthDate, String localAdress,
      Integer postalCode, String city, String phoneNumber, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.localAdress = localAdress;
    this.postalCode = postalCode;
    this.city = city;
    this.email = email;
    this.password = password;
    this.phoneNumber = phoneNumber;
  }

  public User(String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }


  public User(String email, String password) {
    this.email = email;
    this.password = password;
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

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getLocalAdress() {
    return localAdress;
  }

  public void setLocalAdress(String localAdress) {
    this.localAdress = localAdress;
  }

  public Integer getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(Integer postalCode) {
    this.postalCode = postalCode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
