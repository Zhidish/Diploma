package diploma.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/error")
    public String error(){

        return "error";
    }

    @GetMapping("/fchan")
    public String fchan(){

        return "fchan";

    }



}
