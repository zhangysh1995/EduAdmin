package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by KellyZhang on 2017/5/31.
 */

@Controller
public class register {
    // auto-generated stub

    @RequestMapping("/register")
    public String newUser() {

        return "users/register";
    }



}
