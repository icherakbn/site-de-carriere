package ma.enset.careerwebsite.controller;

import ma.enset.careerwebsite.service.UserService;
import ma.enset.careerwebsite.web.UserSignUpDto;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@SpringBootApplication
@RestController
@Service
@RequestMapping("/user/sign")
public class UserSignUpController {
    private final UserService userService;
    public UserSignUpController(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserSignUpDto userSignUpDto(){
        return new UserSignUpDto();
    }

    @PostMapping
    public String ShowSignUpForm(Model model){
        model.addAttribute("user", new UserSignUpDto());
        return "signup";
    }

}
