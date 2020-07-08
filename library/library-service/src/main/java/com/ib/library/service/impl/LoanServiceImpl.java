package com.ib.library.service.impl;

import com.ib.library.model.Book;
import com.ib.library.model.Loan;
import com.ib.library.model.User;
import com.ib.library.model.Work;
import com.ib.library.repository.BookRepository;
import com.ib.library.repository.LoanRepository;
import com.ib.library.service.Utils.ResultOnAction;
import com.ib.library.service.Utils.Status;
import com.ib.library.service.abstraction.LoanService;
import com.ib.library.service.abstraction.UserService;
import com.ib.library.service.abstraction.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

  @Autowired
  private LoanRepository loanRepository;

  @Autowired
  private UserService userService;
  @Autowired
  BookRepository bookRepository;
  @Autowired
  private WorkService workService;

  @Override
  public Loan findLoanById(Integer id) {
    return loanRepository.findById(id).get();
  }

  @Override
  public Loan createLoan(Integer workId, Integer userId) {
    User user = userService.findUserById(userId);
    Work work = workService.findWorkById(workId);
    Loan loan = null;
    if (work.isLoanable()){
      loan = new Loan();
      Calendar calendar = Calendar.getInstance();
      Date borrowingDate = calendar.getTime();
      calendar.add(calendar.MONTH,1);
      Date returningDate = calendar.getTime();
      loan.setUser(user);
      Book book = work.getAvailableBook(work.getBooks());
      loan.setBook(book);
      loan.setBorrowingDate(borrowingDate);
      loan.setReturningDate(returningDate);
      loan.setLoanStatus(Status.STATUS_LOAN_ACTIVATED);
      loanRepository.save(loan);
      book.setBookStatus(false);
      bookRepository.save(book);
    }else{
    }
    return loan;
  }


  @Override
  public List<Loan> findLoanByUser(Integer userId) {
    return loanRepository.findLoanByUser_Id(userId);
  }

  @Override
  public Loan returnLoan(Integer loanId) {
    String result = null;
    Loan loan = findLoanById(loanId);
    if(loan.getLoanStatus().equals(Status.STATUS_LOAN_ACTIVATED) || loan.getLoanStatus().equals(Status.STATUS_LOAN_EXTENDED)){
      loan.setLoanStatus(Status.STATUS_LOAN_RETURNED);
      loanRepository.save(loan);
      Book book = loan.getBook();
      book.setBookStatus(true);
      bookRepository.save(book);
      result = ResultOnAction.LOAN_RETURNED_SUCCESS + " Status : "+loan.getLoanStatus();
    }else {
      result = ResultOnAction.LOAN_RETURNED_ERROR;
    }
    return loan;
  }

  @Override
  public Loan extendLoan(Integer loanId) {
    Loan loan = findLoanById(loanId);
    String result = null;
    if(loan.getLoanStatus().equals(Status.STATUS_LOAN_ACTIVATED)){
      Date returningDate = loan.getReturningDate();
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(returningDate);
      calendar.add(calendar.MONTH,1);
      Date returningDateAfterLoanExtended = calendar.getTime();
      loan.setReturningDate(returningDateAfterLoanExtended);
      loan.setLoanStatus(Status.STATUS_LOAN_EXTENDED);
      loanRepository.save(loan);
      result = ResultOnAction.LOAN_EXTENDED_SUCCESS + " Status : "+loan.getLoanStatus();
    }else {
      result = ResultOnAction.LOAN_EXTENDED_ERROR;
    }
    return loan;
  }

  @Override
  public List<Loan> findAllLoans() {
    return (List<Loan>) loanRepository.findAll();
  }

  @Override
  public List<Loan> findAllLateLoans() {
    Calendar calendar = Calendar.getInstance();
    Date currentDate = calendar.getTime();
    List<Loan> loans = (List<Loan>) loanRepository.findAll();
    List<Loan> lateLoans = null;
    if (!loans.isEmpty()){
      lateLoans = new ArrayList<>();
      for(Loan loan : loans){
        if (loan.getReturningDate().before(currentDate)){
          lateLoans.add(loan);
        }
      }
    }
    return lateLoans;
  }

}
