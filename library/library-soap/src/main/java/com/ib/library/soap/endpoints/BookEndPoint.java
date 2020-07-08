package com.ib.library.soap.endpoints;

import com.ib.library.model.Book;
import com.ib.library.service.abstraction.BookService;
import com.ib.library.soap.Utils;
import library.soap.web_services.BookWS;
import library.soap.web_services.GetBookByIdRequest;
import library.soap.web_services.GetBookByIdResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookEndPoint {

  @Autowired
  BookService bookService;

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getBookByIdRequest")
  @ResponsePayload
  public GetBookByIdResponse getBookById(@RequestPayload GetBookByIdRequest request){
    GetBookByIdResponse bookByIdResponse = new GetBookByIdResponse();
    Book book = this.bookService.findBookById(request.getId());
    BookWS bookWS = null;
    if (book != null){
      bookWS = new BookWS();
      BeanUtils.copyProperties(book, bookWS);
    }
    bookByIdResponse.setBook(bookWS);
    return bookByIdResponse;
  }
}
