package com.ib.library.webapp;


import com.ib.library.wabapp.generated.LoanWS;
import com.ib.library.wabapp.generated.UserWS;
import com.ib.library.wabapp.generated.WorkWS;
import com.ib.library.webapp.ws.DateFormatService;
import com.ib.library.webapp.ws.LoanClient;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loan")
public class LoanController {

  @Autowired
  private LoanClient loanClient;

  @Autowired
  private WorkClient workClient;

  @RequestMapping(value = "/create", method = { RequestMethod.GET, RequestMethod.POST})
  public String create(@RequestParam int id, ModelMap modelMap, HttpServletRequest request){
    String page;
    String borrowingDate = null;
    String returningDate = null;
    HttpSession session = request.getSession();
    WorkWS workWS = workClient.getWorkById(id);
    HashMap userInfo = (HashMap)session.getAttribute("userInfo");
    if(userInfo!=null && userInfo.get("connected").equals("connected")){
      UserWS userWS = (UserWS) userInfo.get("user");
      LoanWS loanWS = this.loanClient.createLoan(userWS.getId(), workWS.getId());
      if(loanWS.getLoanStatus()!=null && loanWS.getLoanStatus().equals("activated")){
        List<LoanWS> loanWSList = this.loanClient.getLoanByUser(userWS.getId());
        for(LoanWS loan : loanWSList){
          borrowingDate = DateFormatService.dateFormat(loan.getBorrowingDate());
          returningDate = DateFormatService.dateFormat(loan.getReturnDate());
        }
        modelMap.addAttribute("borrowingDate", borrowingDate);
        modelMap.addAttribute("returningDate", returningDate);
        modelMap.addAttribute("loans", loanWSList);
        page = "loans";
      }else{
        page = "works_result";
        modelMap.addAttribute("messageToDisplay", "Une erreur est survenue");
      }
    }else{
      page = "login";
    }
    return page;
  }

  @RequestMapping(value = "/prolonger", method = { RequestMethod.GET, RequestMethod.POST})
  public String extend(@RequestParam int id, ModelMap modelMap, HttpServletRequest request){
    String borrowingDate = null;
    String returningDate = null;
    HttpSession session = request.getSession();
    HashMap userInfo = (HashMap)session.getAttribute("userInfo");
    UserWS userWS = (UserWS) userInfo.get("user");
    this.loanClient.extendLoan(id);
    List<LoanWS> loanWSList = this.loanClient.getLoanByUser(userWS.getId());
    for(LoanWS loan : loanWSList){
      borrowingDate = DateFormatService.dateFormat(loan.getBorrowingDate());
      returningDate = DateFormatService.dateFormat(loan.getReturnDate());
    }
    modelMap.addAttribute("borrowingDate", borrowingDate);
    modelMap.addAttribute("returningDate", returningDate);
    modelMap.addAttribute("loans", loanWSList);
    modelMap.addAttribute("loans", loanWSList);
    return "loans";
  }

  @RequestMapping(value = "/my-loans", method = { RequestMethod.GET})
  public String loanByUser(ModelMap modelMap, HttpServletRequest request) {
    String page;
    String borrowingDate = null;
    String returningDate = null;
    HttpSession session = request.getSession();
    HashMap userInfo = (HashMap) session.getAttribute("userInfo");
    if (userInfo != null && "connected".equals(userInfo.get("connected"))) {
      UserWS userWS = (UserWS) userInfo.get("user");
      List<LoanWS> loanWSList = this.loanClient.getLoanByUser(userWS.getId());
      for(LoanWS loan : loanWSList){
        borrowingDate = DateFormatService.dateFormat(loan.getBorrowingDate());
        returningDate = DateFormatService.dateFormat(loan.getReturnDate());
      }
      modelMap.addAttribute("borrowingDate", borrowingDate);
      modelMap.addAttribute("returningDate", returningDate);
      modelMap.addAttribute("loans", loanWSList);
      page = "loans";
    }else{
      page = "login";
    }
    return page;
  }

  @RequestMapping(value = "/restituer", method = { RequestMethod.GET, RequestMethod.POST})
  public String returnLoan(@RequestParam int id, ModelMap modelMap, HttpServletRequest request){
    String borrowingDate = null;
    String returningDate = null;
    HttpSession session = request.getSession();
    HashMap userInfo = (HashMap)session.getAttribute("userInfo");
    UserWS userWS = (UserWS) userInfo.get("user");
    this.loanClient.returnLoan(id);
    List<LoanWS> loanWSList = this.loanClient.getLoanByUser(userWS.getId());
    for(LoanWS loan : loanWSList){
      borrowingDate = DateFormatService.dateFormat(loan.getBorrowingDate());
      returningDate = DateFormatService.dateFormat(loan.getReturnDate());
    }
    modelMap.addAttribute("borrowingDate", borrowingDate);
    modelMap.addAttribute("returningDate", returningDate);
    modelMap.addAttribute("loans", loanWSList);
    return "loans";
  }

}
