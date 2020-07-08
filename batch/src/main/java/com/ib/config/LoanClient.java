package com.ib.config;

import com.ib.generated.*;
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

  public List<LoanWS> getAllLateLoans(){
    GetLateLoansRequest lateLoansRequest = new GetLateLoansRequest();
    GetLateLoansResponse lateLoansResponse = (GetLateLoansResponse) getWebServiceTemplate()
            .marshalSendAndReceive(Constants.WSDL_URI, lateLoansRequest,
                    new SoapActionCallback(
                            Constants.NAMESPACE_URI + "/GetLateLoansRequest"));
    return lateLoansResponse.getLoans();
  }

}
