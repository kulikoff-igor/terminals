package by.diplom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by admin on 21.04.2018.
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public ModelAndView login() {

        return new ModelAndView("login.html");
    }
    @GetMapping("/index")
    public ModelAndView index() {

        return new ModelAndView("index.html");
    }
}