package com.ib.library.soap.endpoints;

import com.ib.library.model.Loan;
import com.ib.library.service.abstraction.LoanService;
import com.ib.library.soap.Utils;
import library.soap.web_services.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


@Endpoint
public class LoanEndPoint {

  @Autowired
  private LoanService loanService;

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getLoanByIdRequest")
  @ResponsePayload
  public GetLoanByIdResponse getLoanById(@RequestPayload GetLoanByIdRequest request){
    GetLoanByIdResponse loanByIdResponse = new GetLoanByIdResponse();
    Loan loan = this.loanService.findLoanById(request.getId());
    LoanWS loanWS = null;
    if (loan != null){
      loanWS = new LoanWS();
      BeanUtils.copyProperties(loan, loanWS);
    }
    loanByIdResponse.setLoan(loanWS);
    return loanByIdResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getLoanByUserRequest")
  @ResponsePayload
  public GetLoanByUserResponse getLoanByUser (@RequestPayload GetLoanByUserRequest request){
    GetLoanByUserResponse loanByUserResponse = new GetLoanByUserResponse();
    List<Loan> loans = loanService.findLoanByUser(request.getUserId());
    loanByUserResponse.getLoan().addAll(populateReturnList(loans));
    return loanByUserResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getLateLoansRequest")
  @ResponsePayload
  public GetLateLoansResponse getLateLoans (@RequestPayload GetLateLoansRequest request){
    GetLateLoansResponse lateLoansResponse = new GetLateLoansResponse();
    List<Loan> loans = loanService.findAllLateLoans();
    lateLoansResponse.getLoans().addAll(populateReturnList(loans));
    return lateLoansResponse;
  }


  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getCreateLoanRequest")
  @ResponsePayload
  public GetCreateLoanResponse createLoan(@RequestPayload GetCreateLoanRequest loanRequest){
    GetCreateLoanResponse loanResponse = new GetCreateLoanResponse();
    LoanWS loanWS = new LoanWS();
    Loan loan = this.loanService.createLoan(loanRequest.getWorkId(), loanRequest.getUserId());
    BeanUtils.copyProperties(loan, loanWS);
    copy(loan, loanWS);
    loanResponse.setLoan(loanWS);
    return loanResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getExtendLoanRequest")
  @ResponsePayload
  public GetExtendLoanResponse extendLoan(@RequestPayload GetExtendLoanRequest loanRequest){
    GetExtendLoanResponse loanResponse = new GetExtendLoanResponse();
    LoanWS loanWS = new LoanWS();
    Loan loan = this.loanService.extendLoan(loanRequest.getLoanId());
    BeanUtils.copyProperties(loan, loanWS);
    copy(loan, loanWS);
    loanResponse.setLoan(loanWS);
    return loanResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getReturnLoanRequest")
  @ResponsePayload
  public GetReturnLoanResponse returnLoan(@RequestPayload GetReturnLoanRequest loanRequest){
    GetReturnLoanResponse loanResponse = new GetReturnLoanResponse();
    LoanWS loanWS = new LoanWS();
    Loan loan = this.loanService.returnLoan(loanRequest.getLoanId());
    BeanUtils.copyProperties(loan, loanWS);
    copy(loan, loanWS);
    loanResponse.setLoan(loanWS);
    return loanResponse;
  }

  private List<LoanWS> populateReturnList(List<Loan> loanList){
    List<LoanWS> loanWSList = new ArrayList<>();
    for (Loan loan : loanList){
      LoanWS loanWS = new LoanWS();
      BeanUtils.copyProperties(loan, loanWS);
      copy(loan, loanWS);
      loanWSList.add(loanWS);
    }
    return loanWSList;
  }

  public void copy(Loan loan, LoanWS loanWS){
    BookWS bookWS = new BookWS();
    UserWS userWS = new UserWS();

    BeanUtils.copyProperties(loan.getUser(), userWS);
    BeanUtils.copyProperties(loan.getBook(), bookWS);

    userWS.setId(loan.getUser().getId());
    userWS.setFirstName(loan.getUser().getFirstName());
    userWS.setLastName(loan.getUser().getLastName());
    userWS.setEmail(loan.getUser().getEmail());

    bookWS.setId(loan.getBook().getId());
    bookWS.setEsbn(loan.getBook().getISBN());
    bookWS.setBookStatus(loan.getBook().getBookStatus());;

    XMLGregorianCalendar borrowingDate = Utils.toXMLGregorianCalendar(loan.getBorrowingDate());
    XMLGregorianCalendar returningDate = Utils.toXMLGregorianCalendar(loan.getReturningDate());

    loanWS.setBorrowingDate(borrowingDate);
    loanWS.setReturnDate(returningDate);
    loanWS.setBook(bookWS);
    loanWS.setUser(userWS);
  }

}
