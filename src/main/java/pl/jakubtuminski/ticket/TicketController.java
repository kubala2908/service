package pl.jakubtuminski.ticket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jakubtuminski.producer.Producer;

import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {
    private static final Logger log = LoggerFactory.getLogger(TicketController.class);
    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/add")
    String ticketAddGet(Model model){
        model.addAttribute("ticket", new Ticket());
        return "/ticket/ticketAddForm";
    }

    @PostMapping("/add")
    String ticketAddPost(Ticket ticket){
        ticketRepository.save(ticket);
        return "redirect:/ticket/list";
    }

    @GetMapping("/list")
    String ticketList(Model model){
        List<Ticket> ticketList = ticketRepository.findAll();
        model.addAttribute("tickets", ticketList);
        return "/ticket/ticketList";
    }
}
