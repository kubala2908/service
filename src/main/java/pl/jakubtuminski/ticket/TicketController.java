package pl.jakubtuminski.ticket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.jakubtuminski.client.Client;
import pl.jakubtuminski.client.ClientRepository;
import pl.jakubtuminski.machine.Machine;
import pl.jakubtuminski.machine.MachineRepository;
import pl.jakubtuminski.user.User;
import pl.jakubtuminski.user.UserRepository;

import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    private static final Logger log = LoggerFactory.getLogger(TicketController.class);
    private final TicketRepository ticketRepository;
    private final MachineRepository machineRepository;
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final TicketService ticketService;

    public TicketController(TicketRepository ticketRepository, MachineRepository machineRepository, UserRepository userRepository, ClientRepository clientRepository, TicketService ticketService) {
        this.ticketRepository = ticketRepository;
        this.machineRepository = machineRepository;
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.ticketService = ticketService;
    }

    @GetMapping("/add")
    String ticketAddGet(Model model){
        model.addAttribute("ticketDto", new TicketDto());
        List<Client> clientList = clientRepository.findAll();
        model.addAttribute("clients", clientList);
        List<Machine> machineList = machineRepository.findAll();
        model.addAttribute("machines", machineList);
        List<User> userList = userRepository.findAll();
        model.addAttribute("users", userList);
        return "/ticket/ticketAddForm";
    }

    @PostMapping("/add")
    @ResponseBody
    String ticketAddPost(TicketDto ticketDto, @RequestParam Long idMachine, @RequestParam Long idClient, @RequestParam Long idManager, @RequestParam Long idTechnician){
        ticketService.saveTicket(ticketDto, idClient, idMachine, idManager, idTechnician    );
//        return "redirect:/ticket/list";
        return "dodano";
    }

    @GetMapping("/list")
    String ticketList(Model model){
        List<Ticket> ticketList = ticketRepository.findAll();
        model.addAttribute("tickets", ticketList);
        return "/ticket/ticketList";
    }

    @GetMapping("/info/{ticketId}")
    String ticketInfo(@PathVariable Long ticketId, Model model) {
        model.addAttribute("ticket", ticketRepository.findTicketById(ticketId));
        return "/ticket/ticketInfo";
    }
}
