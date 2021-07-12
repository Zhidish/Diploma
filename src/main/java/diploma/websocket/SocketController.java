package diploma.websocket;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class SocketController {


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greetings greeting(Greetings greetings) throws Exception{




        Thread.sleep(1000);
        return new Greetings("Hello"+greetings.getName());
    }


}
