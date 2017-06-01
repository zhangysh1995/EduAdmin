package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by KellyZhang on 2017/5/31.
 */
@Controller
public class Login {

    @RequestMapping("/login")
    public String login(Model model, @RequestParam(value="username", defaultValue= "") String username,
            @RequestParam(value="password", defaultValue = "") String password)
        {

        return "/users/me";
    }
}
