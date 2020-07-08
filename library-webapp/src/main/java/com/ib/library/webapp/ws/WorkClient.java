package com.ib.library.webapp.ws;

import com.ib.library.wabapp.generated.GetAllWorksRequest;
import com.ib.library.wabapp.generated.GetAllWorksResponse;
import com.ib.library.wabapp.generated.GetAvailableBookSizeRequest;
import com.ib.library.wabapp.generated.GetAvailableBookSizeResponse;
import com.ib.library.wabapp.generated.GetWorkByAuthorNameRequest;
import com.ib.library.wabapp.generated.GetWorkByAuthorNameResponse;
import com.ib.library.wabapp.generated.GetWorkByIdRequest;
import com.ib.library.wabapp.generated.GetWorkByIdResponse;
import com.ib.library.wabapp.generated.GetWorkByTitleRequest;
import com.ib.library.wabapp.generated.GetWorkByTitleResponse;
import com.ib.library.wabapp.generated.WorkWS;
import java.util.List;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class WorkClient extends WebServiceGatewaySupport {

  public WorkWS getWorkById(int id){
    GetWorkByIdRequest workByIdRequest = new GetWorkByIdRequest();
    workByIdRequest.setId(id);

    GetWorkByIdResponse workByIdResponse = (GetWorkByIdResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, workByIdRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetWorkByIdRequest"));

    return workByIdResponse.getWork();
  }

  public List<WorkWS> getAllWorks(){
    GetAllWorksRequest worksRequest = new GetAllWorksRequest();
    GetAllWorksResponse getAllWorksResponse = (GetAllWorksResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, worksRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetAllWorksRequest"));
    return getAllWorksResponse.getWorks();
  }

  public List<WorkWS> getWorksByTitle(String title){
    GetWorkByTitleRequest workByTitleRequest = new GetWorkByTitleRequest();
    workByTitleRequest.setTitle(title);

    GetWorkByTitleResponse workByTitleResponse = (GetWorkByTitleResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, workByTitleRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetWorkByTitleRequest"));

    return workByTitleResponse.getWork();
  }

  public List<WorkWS> getWorksByAuthorName(String author){
    GetWorkByAuthorNameRequest workByAuthorNameRequest = new GetWorkByAuthorNameRequest();
    workByAuthorNameRequest.setName(author);

    GetWorkByAuthorNameResponse workByAuthorNameResponse = (GetWorkByAuthorNameResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, workByAuthorNameRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetWorkByAuthorNameRequest"));

    return workByAuthorNameResponse.getWork();
  }

  public int getAvailableBookSize(int id){
    GetAvailableBookSizeRequest availableBookSizeRequest = new GetAvailableBookSizeRequest();
    availableBookSizeRequest.setWorkId(id);

    GetAvailableBookSizeResponse availableBookSizeResponse = (GetAvailableBookSizeResponse) getWebServiceTemplate()
        .marshalSendAndReceive(Constants.WSDL_URI, availableBookSizeRequest,
            new SoapActionCallback(
                Constants.NAMESPACE_URI + "/GetAvailableBookSizeRequest"));
    return availableBookSizeResponse.getSize();
  }
}
