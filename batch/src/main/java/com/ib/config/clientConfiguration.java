package com.ib.config;

import com.ib.config.LoanClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class clientConfiguration {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.ib.generated");
    marshaller.setMtomEnabled(true);
    return marshaller;
  }

  @Bean
  public LoanClient loanClient(Jaxb2Marshaller marshaller) {
    LoanClient loanClient = new LoanClient();
    loanClient.setDefaultUri("http://localhost:8080/ws");
    loanClient.setMarshaller(marshaller);
    loanClient.setUnmarshaller(marshaller);
    return loanClient;
  }

}
