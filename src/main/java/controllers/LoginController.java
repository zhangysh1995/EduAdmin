package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by KellyZhang on 2017/5/31.
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView login()
    {

        return new ModelAndView("/users/login");
    }

    @RequestMapping(value="/loginAction.do", method=RequestMethod.POST)
    public String submit( Model model, @RequestParam(value="username", defaultValue= "") String username,
                          @RequestParam(value="password", defaultValue = "") String password)
    {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "/users/me";
    }
}
