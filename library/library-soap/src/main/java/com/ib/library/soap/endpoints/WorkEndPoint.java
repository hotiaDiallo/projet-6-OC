package com.ib.library.soap.endpoints;

import com.ib.library.model.Book;
import com.ib.library.model.Work;
import com.ib.library.service.abstraction.WorkService;
import com.ib.library.soap.Utils;
import library.soap.web_services.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Endpoint
public class WorkEndPoint{

  @Autowired
  private WorkService workService;

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getWorkByIdRequest")
  @ResponsePayload
  public GetWorkByIdResponse getWorkById(@RequestPayload GetWorkByIdRequest request){
    GetWorkByIdResponse workByIdResponse = new GetWorkByIdResponse();
    Work work = this.workService.findWorkById(request.getId());
    WorkWS workWS = null;
    if (work != null){
      workWS = new WorkWS();
      BeanUtils.copyProperties(work, workWS);
    }
    workByIdResponse.setWork(workWS);
    return workByIdResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getAllWorksRequest")
  @ResponsePayload
  public GetAllWorksResponse getAllWorks (@RequestPayload GetAllWorksRequest request){
    GetAllWorksResponse workResponse = new GetAllWorksResponse();
    List<Work> works = workService.getAllWorks();
    workResponse.getWorks().addAll(populateReturnList(works));
    return workResponse;
  }


  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getWorkByTitleRequest")
  @ResponsePayload
  public GetWorkByTitleResponse getWorkByTitle (@RequestPayload GetWorkByTitleRequest request){
    GetWorkByTitleResponse workResponse = new GetWorkByTitleResponse();
    List<Work> works = workService.findWorkByTitle(request.getTitle());
    workResponse.getWork().addAll(populateReturnList(works));
    return workResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getWorkByAuthorNameRequest")
  @ResponsePayload
  public GetWorkByAuthorNameResponse getWorkByAuthorName (@RequestPayload GetWorkByAuthorNameRequest request){
    GetWorkByAuthorNameResponse workResponse = new GetWorkByAuthorNameResponse();
    String name = request.getName();
    List<Work> works = workService.findWorkByAuthorName(name);
    workResponse.getWork().addAll(populateReturnList(works));
    return workResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getWorkByAuthorRequest")
  @ResponsePayload
  public GetWorkByAuthorResponse getWorkByAuthor (@RequestPayload GetWorkByAuthorRequest request){
    GetWorkByAuthorResponse workResponse = new GetWorkByAuthorResponse();
    int id = request.getId();
    List<Work> works = workService.findWorkByAuthor_Id(id);
    workResponse.getWork().addAll(populateReturnList(works));
    return workResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getWorkByReleaseDateRequest")
  @ResponsePayload
  public GetWorkByReleaseDateResponse getWorkByReleaseDate (@RequestPayload GetWorkByReleaseDateRequest request){
    GetWorkByReleaseDateResponse workResponse = new GetWorkByReleaseDateResponse();
    Date releaseDate = null;
    BeanUtils.copyProperties(releaseDate, request.getReleaseDate());
    List<Work> works = workService.findWorkByReleaseDate(releaseDate);
    workResponse.getWork().addAll(populateReturnList(works));
    return workResponse;
  }

  @PayloadRoot(namespace = Utils.NAMESPACE_URI, localPart = "getAvailableBookSizeRequest")
  @ResponsePayload
  public GetAvailableBookSizeResponse getAvailableBookSize (@RequestPayload GetAvailableBookSizeRequest request){
    GetAvailableBookSizeResponse workResponse = new GetAvailableBookSizeResponse();
    Work work = workService.findWorkById(request.getWorkId());
    int size = workService.getAvailableBooksSize(work);
    workResponse.setSize(size);
    return workResponse;
  }

  private List<WorkWS> populateReturnList(List<Work> workList){
    List<WorkWS> workWSList = new ArrayList<>();
    for (Work work : workList){
      WorkWS workWS = new WorkWS();
      copy(work, workWS);
      BeanUtils.copyProperties(work, workWS);
      workWSList.add(workWS);
    }
    return workWSList;
  }

  public void copy(Work work, WorkWS workWS){
    BookWS bookWS = new BookWS();
    AuthorWS authorWS = new AuthorWS();
    BeanUtils.copyProperties(work.getBooks(), bookWS);
    BeanUtils.copyProperties(work.getAuthor(), authorWS);
    for(Book book : work.getBooks()){
      bookWS.setId(book.getId());
      bookWS.setBookStatus(book.getBookStatus());
      bookWS.setEsbn(book.getISBN());
    }
    workWS.setAuthor(authorWS);
    workWS.setBooks(bookWS);
    workWS.setId( work.getId());
  }
}

