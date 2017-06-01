package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import roles.impl.Student;

/**
 * Created by KellyZhang on 2017/5/31.
 */

@Controller
public class StudentController {
    // auto-generated stub

    @RequestMapping(value="/student/register", method= RequestMethod.GET)
    public ModelAndView showForm()
    {

        return new ModelAndView("/users/studentRegister", "student", new Student());
    }

    @RequestMapping(value="/student/new", method=RequestMethod.POST)
    public String submit(@Validated @ModelAttribute("student") Student student, BindingResult result, ModelMap model){

        if(result.hasErrors()) return "errors";

        model.addAttribute("username", student.getUsername());
        model.addAttribute("password", student.getPassword());
        return "/users/me";
    }

}