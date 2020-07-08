package com.ib.library.soap.endpoints;

import com.ib.library.model.User;
import com.ib.library.service.abstraction.UserService;
import com.ib.library.soap.Utils;
import library.soap.web_services.GetUserByEmailRequest;
import library.soap.web_services.GetUserByEmailResponse;
import library.soap.web_services.GetUserByIdRequest;
import library.soap.web_services.GetUserByIdResponse;
import library.soap.web_services.GetUserLoginRequest;
import library.soap.web_services.GetUserLoginResponse;
import library.soap.web_services.UserWS;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserEndPoint {

  @Autowired
  private UserService userService;

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getUserByIdRequest")
  @ResponsePayload
  public GetUserByIdResponse getUserById(@RequestPayload GetUserByIdRequest request){
    GetUserByIdResponse userByIdResponse = new GetUserByIdResponse();
    User user = this.userService.findUserById(request.getId());
    UserWS userWS = null;
    if (user != null){
      userWS = new UserWS();
      BeanUtils.copyProperties(user, userWS);
    }
    userByIdResponse.setUser(userWS);
    return userByIdResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getUserByEmailRequest")
  @ResponsePayload
  public GetUserByEmailResponse getUserByEmail(@RequestPayload GetUserByEmailRequest request){
    GetUserByEmailResponse userByEmailResponse = new GetUserByEmailResponse();
    User user = this.userService.findUserByEmail(request.getEmail());
    UserWS userWS = null;
    if (user != null){
      userWS = new UserWS();
      BeanUtils.copyProperties(user, userWS);
    }
    userByEmailResponse.setUser(userWS);
    return userByEmailResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "GetUserLoginRequest")
  @ResponsePayload
  public GetUserLoginResponse getUserLogin(@RequestPayload GetUserLoginRequest loginRequest){
    GetUserLoginResponse loginResponse = new GetUserLoginResponse();
    String result = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
    loginResponse.setResponse(result);
    return loginResponse;
  }
}
