package ac.daffodil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by codin on 3/20/2018.
 */

@Controller
public class HomeController {

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fragments/layout");
        return modelAndView;
    }
    @RequestMapping(value = { "/defaultLogin" }, method = RequestMethod.GET)
    public String defaultLogin(HttpServletRequest request) {
        if(request.isUserInRole("admin")){
            return "redirect:/admin/adminDashPage";
        }else if(request.isUserInRole("user")){
            return "redirect:/user/userDashPage";
        }
        return "redirect:/loginFailure";
    }

    @RequestMapping(value = { "/admin/adminDashPage" }, method = RequestMethod.GET)
    public ModelAndView adminIndex(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",  request.getParameter("message"));
        modelAndView.setViewName("admin/adminDash");
        return modelAndView;
    }

    @RequestMapping(value = { "/user/userDashPage" }, method = RequestMethod.GET)
    public ModelAndView userIndex(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/userDash");
        return modelAndView;
    }
}
