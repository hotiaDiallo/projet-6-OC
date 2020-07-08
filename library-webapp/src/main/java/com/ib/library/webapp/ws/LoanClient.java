package com.ib.library.webapp.ws;

import com.ib.library.wabapp.generated.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

public class LoanClient extends WebServiceGatewaySupport {

  public LoanWS getLoanById(int id){
    GetLoanByIdRequest loanByIdRequest = new GetLoanByIdRequest();
    loanByIdRequest.setId(id);

    GetLoanByIdResponse loanByIdResponse = (GetLoanByIdResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, loanByIdRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetLoanByIdRequest"));

    return loanByIdResponse.getLoan();
  }

  public List<LoanWS> getLoanByUser(int userId){
    GetLoanByUserRequest loanByUserRequest = new GetLoanByUserRequest();
    loanByUserRequest.setUserId(userId);

    GetLoanByUserResponse loanByUserResponse = (GetLoanByUserResponse) getWebServiceTemplate()
            .marshalSendAndReceive(Constants.WSDL_URI, loanByUserRequest,
                    new SoapActionCallback(
                            Constants.NAMESPACE_URI + "/GetLoanByUserRequest"));

    return loanByUserResponse.getLoan();
  }

  public LoanWS createLoan(int userId, int workId){
    GetCreateLoanRequest loanRequest = new GetCreateLoanRequest();
    loanRequest.setUserId(userId);
    loanRequest.setWorkId(workId);

    GetCreateLoanResponse loanResponse = (GetCreateLoanResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, loanRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetCreateLoanRequest"));

    return loanResponse.getLoan();
  }

  public LoanWS extendLoan(int loanId){
    GetExtendLoanRequest loanRequest = new GetExtendLoanRequest();
    loanRequest.setLoanId(loanId);

    GetExtendLoanResponse loanResponse = (GetExtendLoanResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, loanRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetExtendLoanRequest"));

    return loanResponse.getLoan();
  }

  public LoanWS returnLoan(int loanId){
    GetReturnLoanRequest loanRequest = new GetReturnLoanRequest();
    loanRequest.setLoanId(loanId);

    GetReturnLoanResponse loanResponse = (GetReturnLoanResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, loanRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetReturnLoanRequest"));

    return loanResponse.getLoan();
  }

  public List<LoanWS> getAllLateLoans(){
    GetLateLoansRequest lateLoansRequest = new GetLateLoansRequest();
    GetLateLoansResponse lateLoansResponse = (GetLateLoansResponse) getWebServiceTemplate()
            .marshalSendAndReceive(Constants.WSDL_URI, lateLoansRequest,
                    new SoapActionCallback(
                            Constants.NAMESPACE_URI + "/GetLateLoansRequest"));
    return lateLoansResponse.getLoans();
  }
}
