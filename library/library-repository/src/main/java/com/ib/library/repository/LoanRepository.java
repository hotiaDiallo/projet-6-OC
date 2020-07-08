package com.ib.library.repository;

import com.ib.library.model.Loan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan, Integer> {
  List<Loan> findLoanByUser_Id(Integer userId);
  List<Loan> findLoanByUser_email(String email);
}