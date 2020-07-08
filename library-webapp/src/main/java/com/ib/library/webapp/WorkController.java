package com.ib.library.webapp;

import com.ib.library.wabapp.generated.WorkWS;
import com.ib.library.webapp.ws.WorkClient;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ouvrages")
public class WorkController {

  @Autowired
  private WorkClient workClient;

  @RequestMapping(value = "all", method = {RequestMethod.GET})
  public String getAllWorks(ModelMap modelMap, HttpServletRequest request){
    HashMap availablesBooksList = new HashMap();
    List<WorkWS> workWSList = this.workClient.getAllWorks();
    for(WorkWS work : workWSList){
      int availableBooks = this.workClient.getAvailableBookSize(work.getId());
      availablesBooksList.putIfAbsent(work.getBooks().getId(), availableBooks);
      modelMap.addAttribute("nbAvailableBooks", availablesBooksList);
    }
    modelMap.addAttribute("works", workWSList);
    return "all_works";
  }

  @RequestMapping(value = "rechercher", method = {RequestMethod.GET, RequestMethod.POST})
  public String getSearcForm(ModelMap modelMap, HttpServletRequest request){

    HttpSession session = request.getSession();
    session.setAttribute("formSearch", "formSearch");
    return "works_search";
  }

  @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
  public String searchBooks(ModelMap modelMap, HttpServletRequest request){

    HashMap availablesBooksList = new HashMap();
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    int availableBooks = 0;
    String page = null;
    List<WorkWS> workWS = null;
    if (title!=""){
      workWS = this.workClient.getWorksByTitle(title);
      if(workWS.isEmpty()){
        modelMap.addAttribute("messageToDisplay", "Aucun résultat trouvé");
        page = "works_search";
      }else{
        modelMap.addAttribute("works", workWS);
        for(WorkWS work : workWS){
          availableBooks = this.workClient.getAvailableBookSize(work.getId());
          availablesBooksList.putIfAbsent(work.getBooks().getId(), availableBooks);
          modelMap.addAttribute("nbAvailableBooks", availablesBooksList);
        }
        page = "works_result";
      }
    }else if(author!=""){
      workWS = this.workClient.getWorksByAuthorName(author);
      if(workWS.isEmpty()){
        modelMap.addAttribute("messageToDisplay", "Aucun résultat trouvé");
        page = "works_search";
      }else{
        modelMap.addAttribute("works", workWS);
        for(WorkWS work : workWS){
          availableBooks = this.workClient.getAvailableBookSize(work.getId());
          availablesBooksList.putIfAbsent(work.getBooks().getId(), availableBooks);
          modelMap.addAttribute("nbAvailableBooks", availablesBooksList);
        }
        page = "works_result";
      }
    }else {
      modelMap.addAttribute("messageToDisplay", "Veuillez saisir un titre ou nom d'auteur ");
      page = "works_search";
    }
    return page;
  }
}
