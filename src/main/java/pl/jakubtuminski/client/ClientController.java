package pl.jakubtuminski.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    private static final Logger log = LoggerFactory.getLogger(ClientController.class);
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/add")
    String clientAddGet (Model model){
        model.addAttribute("client", new Client());
        return "/client/clientAddForm";
    }

    @PostMapping("/add")
    String producerAddPost(Client client){
        clientRepository.save(client);
        return "redirect:/client/list";
    }

    @GetMapping("/list")
    String producersList(Model model){
        List<Client> clientList = clientRepository.findAll();
        model.addAttribute("clients", clientList);
        return "/client/clientList";
    }

    //info

    //delete
}
