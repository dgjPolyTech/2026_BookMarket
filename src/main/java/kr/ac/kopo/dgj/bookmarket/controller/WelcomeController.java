package kr.ac.kopo.dgj.bookmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcomeMethods(){
        return "welcome";
    }
}
