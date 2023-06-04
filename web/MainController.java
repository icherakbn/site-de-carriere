package ma.enset.careerwebsite.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@SpringBootApplication
@RestController
public class MainController {
    @PostMapping ("/user/sign/signin")
    public String login() {
        return "signin";
    }

    @PostMapping("/")
    public String home(){
        return"homecand";
    }
}
