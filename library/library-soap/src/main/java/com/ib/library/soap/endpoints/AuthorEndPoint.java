package com.ib.library.soap.endpoints;

import com.ib.library.model.Author;
import com.ib.library.service.abstraction.AuthorService;
import com.ib.library.soap.Utils;
import library.soap.web_services.AuthorWS;
import library.soap.web_services.GetAuthorByIdRequest;
import library.soap.web_services.GetAuthorByIdResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AuthorEndPoint {

  @Autowired
  AuthorService authorService;

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getAuthorByIdRequest")
  @ResponsePayload
  public GetAuthorByIdResponse getAuthorById(@RequestPayload GetAuthorByIdRequest request){
    GetAuthorByIdResponse authorByIdResponse = new GetAuthorByIdResponse();
    Author author = this.authorService.findAuthorById(request.getId());
    AuthorWS authorWS = null;
    if (author != null){
      authorWS = new AuthorWS();
      BeanUtils.copyProperties(author, authorWS);
    }
    authorByIdResponse.setAuthor(authorWS);
    return authorByIdResponse;
  }

}
