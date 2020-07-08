package com.ib.library.webapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {



    @RequestMapping("")
    public String homePage(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession() ;
        modelMap.addAttribute("session", session.getAttribute("email"));
        return "home";
    }

    @RequestMapping("layout")
    public String defaultPage() {
        return "layout";
    }
}

