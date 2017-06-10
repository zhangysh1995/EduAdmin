package controllers;

import database.TeacherManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import roles.impl.Teacher;

/**
 * Created by KellyZhang on 2017/6/1.
 */
@Controller
public class TeacherController {
    // auto-generated stub

    @RequestMapping(value="/teacher/register", method= RequestMethod.GET)
    public ModelAndView showForm()
    {

        return new ModelAndView("/users/teacherRegister", "teacher", new Teacher());
    }

    @RequestMapping(value="/teacher/new", method=RequestMethod.POST)
    public String submit(@Validated @ModelAttribute("Teacher") Teacher teacher, BindingResult result, Model model){

        if(result.hasErrors()) return "errors";
        modelHelper(model, teacher);

        TeacherManager.add(teacher);
        return "/users/teacherMe";
    }

    @RequestMapping(value = "/teacher/login", method = RequestMethod.GET)
    public String validate(Model model,
                           @ModelAttribute("teacher") Teacher teacher,
                           @RequestParam(value="username", defaultValue = "") String username,
                           @RequestParam(value="password", defaultValue = "") String password) {

        if (TeacherManager.validate(username, password)) {
            teacher = TeacherManager.fetch(username, password);
            modelHelper(model, teacher);
            return "/users/teacherMe";
        } else return "/users/loginFailed";
    }

    /*
        operations on changing info
     */
    @RequestMapping(value="/teacher/change", method=RequestMethod.POST)
    public String change(Model model,
                         @ModelAttribute("teacher") Teacher teacher) {
        TeacherManager.update(teacher);

        modelHelper(model, teacher);
        return "/users/teacherMe";
    }

    @RequestMapping(value="/teacher/scores", method=RequestMethod.GET)
    public String scores() {
        return "/utilities/editScores";
    }

    private Model modelHelper(Model model, Teacher teacher) {
        model.addAttribute("username", teacher.getUsername());
        model.addAttribute("password", teacher.getPassword());
        model.addAttribute("name", teacher.getName());
        model.addAttribute("teacherNo", teacher.getTeacherNo());
        model.addAttribute("dept", teacher.getDept());

        return model;
    }
}
