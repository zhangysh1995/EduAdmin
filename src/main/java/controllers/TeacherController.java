package controllers;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import roles.impl.Teacher;

/**
 * Created by KellyZhang on 2017/6/1.
 */
public class TeacherController {
    // auto-generated stub

    @RequestMapping(value="/teacher/register", method= RequestMethod.GET)
    public ModelAndView showForm()
    {

        return new ModelAndView("/users/teacherRegister", "teacher", new Teacher());
    }

    @RequestMapping(value="/teacher/new", method=RequestMethod.POST)
    public String submit(@Validated @ModelAttribute("Teacher") Teacher teacher, BindingResult result, ModelMap model){

        if(result.hasErrors()) return "errors";

        model.addAttribute("username", teacher.getUsername());
        model.addAttribute("password", teacher.getPassword());
        return "/users/me";
    }

}
