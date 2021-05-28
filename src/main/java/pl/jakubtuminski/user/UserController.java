package pl.jakubtuminski.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
//@RequestMapping("/user")
public class UserController {
    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add")
    public String index(Model model, Principal principal) {
        model.addAttribute("message", "You are logged in as " + principal.getName());
        return "index";
    }

    @GetMapping("/")
    public String userAddGet(Model model){
        model.addAttribute("user", new User());
        return "/user/userRegistrationForm";
    }

    @PostMapping("/user/add")
    @ResponseBody
    public String userAddPost(User user){
        userService.saveUser(user);
        return "zapisano";
    }
}
