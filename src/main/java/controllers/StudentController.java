package controllers;

import database.StudentManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    // auto-generated stubs

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

        StudentManager.add(student);
        return "/users/me";
    }

    @RequestMapping(value="/student/login", method=RequestMethod.GET)
    public String validate(Model model,
//                           @RequestParam(value = "username", defaultValue = "") String username,
//                           @RequestParam(value = "password", defaultValue = "") String password) {

                        @ModelAttribute("username") String username, @ModelAttribute("password") String password)
    {

        System.out.println("username: " + username + " password: " + password);

        if (StudentManager.validate(username, password)) {
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "/users/me";
        }
        else return "/users/loginFailed";
    }
}