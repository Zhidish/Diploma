package diploma.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocketControlerr {




    @GetMapping("/app/hello")
    String foo(){

        return "socket";
    }

}
