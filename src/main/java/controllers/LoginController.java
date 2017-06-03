package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String submit(
            @RequestParam(value="username", defaultValue= "") String username,
                               @RequestParam(value="password", defaultValue = "") String password,
                               @RequestParam(value="role", defaultValue = "student") String role,
                               RedirectAttributes model
                              )
    {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        if (role.equals("student"))
            return "redirect:/student/login";
        else if (role.equals("teacher"))
            return "redirect:/teacher/login";
        else return "/users/loginFailed";
//        model.addAttribute("username", username);
//        model.addAttribute("password", password);
    }
}
