package pl.jakubtuminski.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    public final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/info")
    public String index(Model model, Principal principal) {
        model.addAttribute("message", "You are logged in as " + principal.getName());
        return "index";
    }

    @GetMapping("/add")
    public String userAddGet(Model model){
        model.addAttribute("user", new User());
        return "/user/userRegistrationForm";
    }

    @PostMapping("/add")
    public String userAddPost(User user, @RequestParam String role){
        log.info(role);
        userService.saveUser(user, role);
        return "redirect:/user/list";
    }

    @GetMapping("/list")
    public String usersList(Model model){
        List<User> usersList = userRepository.findAll();
        model.addAttribute("users", usersList);
        return "/user/usersList";
    }

    //delate
}
