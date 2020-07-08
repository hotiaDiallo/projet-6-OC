package com.ib.library.webapp;

import com.ib.library.webapp.ws.BookClient;
import com.ib.library.webapp.ws.LoanClient;
import com.ib.library.webapp.ws.UserClient;
import com.ib.library.webapp.ws.WorkClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class clientConfiguration {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.ib.library.wabapp.generated");
    marshaller.setMtomEnabled(true);
    return marshaller;
  }

  @Bean
  public UserClient userClient(Jaxb2Marshaller marshaller) {
    UserClient userClient = new UserClient();
    userClient.setDefaultUri("http://localhost:8080/ws");
    userClient.setMarshaller(marshaller);
    userClient.setUnmarshaller(marshaller);
    return userClient;
  }

//  @Bean
//  public AuthorClient authorClient(Jaxb2Marshaller marshaller) {
//    AuthorClient authorClient = new AuthorClient();
//    authorClient.setDefaultUri("http://localhost:8080/ws");
//    authorClient.setMarshaller(marshaller);
//    authorClient.setUnmarshaller(marshaller);
//    return authorClient;
//  }

  @Bean
  public WorkClient workClient(Jaxb2Marshaller marshaller) {
    WorkClient workClient = new WorkClient();
    workClient.setDefaultUri("http://localhost:8080/ws");
    workClient.setMarshaller(marshaller);
    workClient.setUnmarshaller(marshaller);
    return workClient;
  }

  @Bean
  public LoanClient loanClient(Jaxb2Marshaller marshaller) {
    LoanClient loanClient = new LoanClient();
    loanClient.setDefaultUri("http://localhost:8080/ws");
    loanClient.setMarshaller(marshaller);
    loanClient.setUnmarshaller(marshaller);
    return loanClient;
  }

  @Bean
  public BookClient bookClient(Jaxb2Marshaller marshaller) {
    BookClient bookClient = new BookClient();
    bookClient.setDefaultUri("http://localhost:8080/ws");
    bookClient.setMarshaller(marshaller);
    bookClient.setUnmarshaller(marshaller);
    return bookClient;
  }
}
