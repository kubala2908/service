package pl.jakubtuminski.machine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jakubtuminski.client.Client;
import pl.jakubtuminski.client.ClientRepository;
import pl.jakubtuminski.producer.Producer;
import pl.jakubtuminski.producer.ProducerRepository;

import java.util.List;


@Controller
@RequestMapping("/machine")
public class MachineController {
    private static final Logger log = LoggerFactory.getLogger(MachineController.class);
    private final MachineRepository machineRepository;
    private final ProducerRepository producerRepository;
    private final ClientRepository clientRepository;

    public MachineController(MachineRepository machineRepository, ProducerRepository producerRepository, ClientRepository clientRepository) {
        this.machineRepository = machineRepository;
        this.producerRepository = producerRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/add")
    public String machineAddGet(Model model){
        model.addAttribute("machine", new Machine());
        List<Producer> producerList = producerRepository.findAll();
        model.addAttribute("producers", producerList);
        List<Client> clientList = clientRepository.findAll();
        model.addAttribute("clients", clientList);
        return "/machine/machineAddForm";
    }

    @PostMapping("/add")
    public String machineAddPost(Machine machine, @RequestParam Long idProducer, @RequestParam Long idClient){
        machineRepository.save(machine);
        machine.setProducer(producerRepository.findProducerById(idProducer));
        machine.setClient(clientRepository.findClientById(idClient));
        machineRepository.save(machine);
        return "redirect:/machine/list";
    }

    @GetMapping("/list")
    public String machinesList(Model model){
        List<Machine> machinesList = machineRepository.findAll();
        model.addAttribute("machines", machinesList);
        return "/machine/machinesList";
    }

    //info

    //delete
}
