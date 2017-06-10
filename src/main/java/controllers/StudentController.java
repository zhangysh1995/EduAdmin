package controllers;

import database.StudentManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import roles.impl.Student;

/**
 * Created by KellyZhang on 2017/5/31.
 */

@Controller
public class StudentController {

    @RequestMapping(value = "/student/register", method = RequestMethod.GET)
    public ModelAndView showForm() {

        return new ModelAndView("/users/studentRegister", "student", new Student());
    }

    @RequestMapping(value = "/student/new", method = RequestMethod.POST)
    public String submit(@Validated @ModelAttribute("student") Student student, BindingResult result, Model model) {

        if (result.hasErrors()) return "errors";
        modelHelper(model, student);

        StudentManager.add(student);
        return "/users/studentMe";
    }

    /*
        operaions on student login
     */
    @RequestMapping(value = "/student/login", method = RequestMethod.GET)
    public String validate(Model model,
                           @ModelAttribute("student") Student student,
                           @RequestParam(value = "username", defaultValue = "") String username,
                           @RequestParam(value = "password", defaultValue = "") String password) {

        if (StudentManager.validate(username, password)) {
           student = StudentManager.fetch(username, password);
            modelHelper(model, student);
            return "/users/studentMe";
        } else return "/users/loginFailed";
    }

    /*
        operations on changing info
     */
    @RequestMapping(value="/student/change", method=RequestMethod.POST)
    public String change(Model model,
                         @ModelAttribute("student") Student student) {
        StudentManager.update(student);

        modelHelper(model, student);
        return "/users/studentMe";
    }

    @RequestMapping(value="student/scores", method=RequestMethod.GET)
    public String scores(@RequestParam(value = "studentNo", defaultValue = "00000000") String studentNo,
                         RedirectAttributes model) {

        model.addAttribute("studentNo", studentNo);
        return "redirect:/myscores";
    }

    private Model modelHelper(Model model, Student student) {
        model.addAttribute("username", student.getUsername());
        model.addAttribute("password", student.getPassword());
        model.addAttribute("name", student.getName());
        model.addAttribute("studentNo", student.getStudentNo());
        model.addAttribute("dept", student.getDept());

        return model;
    }

}