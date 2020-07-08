package com.ib.library.webapp;

import com.ib.library.wabapp.generated.UserWS;
import com.ib.library.webapp.ws.Consts;
import com.ib.library.webapp.ws.UserClient;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserClient userClient;

  HashMap userInfo = new HashMap();

  @RequestMapping(value = "/login", method = { RequestMethod.GET})
  public String login(){
    return "login";
  }

  @RequestMapping(value = "/connexion", method = {RequestMethod.GET, RequestMethod.POST})
  public String loginSuccess(ModelMap modelMap, HttpServletRequest request){

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    HttpSession session = request.getSession() ;
    String page = null;
    String actionBefore = "fromHome";

    if (email!="" && password!=""){
      String loginStatus = this.userClient.userLogin(email, password);
      modelMap.addAttribute("loginStatus", loginStatus);
      if(loginStatus != null && loginStatus.equals(Consts.USER_LOGGED_SUCCESS)){
        UserWS userWS = this.userClient.getUserByEmailClientRequest(email);
        userInfo.putIfAbsent("connected", "connected");
        userInfo.putIfAbsent("user", userWS);
        session.setAttribute("userInfo", userInfo) ;
        page = "home";
      }else{
        modelMap.addAttribute("messageToDisplay", "Les donnees saisies sont incorrectes");
        page = "login";
      }
    }else{
      modelMap.addAttribute("messageToDisplay", "Veuillez saisir les donnees requises");
      page = "login";
    }
    return page;
  }

  @RequestMapping(value = "deconnexion", method = {RequestMethod.POST, RequestMethod.GET})
  public String logOut(ModelMap modelMap, HttpServletRequest request){
    HttpSession session = request.getSession() ;
    userInfo.putIfAbsent("connected", "disconnected");
    session.setAttribute("userInfo", userInfo) ;
    return "home";
  }

  @RequestMapping(value = "/loans", method = RequestMethod.GET)
  public String LoansPage(ModelMap model) {
    return "loans";
  }

  @PostMapping(path="/loans/details")
  public String showLoans(@RequestParam(value = "email", required = false) String email, ModelMap modelMap){

    return "loansDetails";
  }
}
