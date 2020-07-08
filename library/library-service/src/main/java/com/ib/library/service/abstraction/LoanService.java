package com.ib.library.service.abstraction;

import com.ib.library.model.Loan;
import java.util.List;

public interface LoanService {

  Loan findLoanById(Integer id);

  Loan createLoan(Integer workId, Integer userId);

  List<Loan> findLoanByUser(Integer userId);

  Loan returnLoan(Integer loanId);
  Loan extendLoan(Integer loanId);

  List<Loan> findAllLoans();

  List<Loan> findAllLateLoans();
}
