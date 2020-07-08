package com.ib.library.webapp.ws;

import com.ib.library.wabapp.generated.GetUserByEmailRequest;
import com.ib.library.wabapp.generated.GetUserByEmailResponse;
import com.ib.library.wabapp.generated.GetUserByIdRequest;
import com.ib.library.wabapp.generated.GetUserByIdResponse;
import com.ib.library.wabapp.generated.GetUserLoginRequest;
import com.ib.library.wabapp.generated.GetUserLoginResponse;
import com.ib.library.wabapp.generated.UserWS;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UserClient extends WebServiceGatewaySupport{
  public UserWS getUserByIdClientRequest(int id){
    GetUserByIdRequest userByIdRequest = new GetUserByIdRequest();
    userByIdRequest.setId(id);

    GetUserByIdResponse userByIdResponse = (GetUserByIdResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, userByIdRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetUserByIdRequest"));

    return userByIdResponse.getUser();
  }

  public UserWS getUserByEmailClientRequest(String email){
    GetUserByEmailRequest userByEmailRequest = new GetUserByEmailRequest();
    userByEmailRequest.setEmail(email);

    GetUserByEmailResponse userByEmailResponse = (GetUserByEmailResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, userByEmailRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetUserByEmailRequest"));

    return userByEmailResponse.getUser();
  }

  public String userLogin(String email, String password){
    GetUserLoginRequest userLoginRequest = new GetUserLoginRequest();
    userLoginRequest.setEmail(email);
    userLoginRequest.setPassword(password);

    GetUserLoginResponse userLoginResponse = (GetUserLoginResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, userLoginRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetUserLoginRequest"));

    return userLoginResponse.getResponse();
  }
}
