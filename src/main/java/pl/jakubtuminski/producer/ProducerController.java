package pl.jakubtuminski.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/producer")
class ProducerController {
    private static final Logger log = LoggerFactory.getLogger(ProducerController.class);
    private final ProducerRepository producerRepository;

    public ProducerController(ProducerRepository producerRepository) {
        this.producerRepository = producerRepository;
    }

    @GetMapping("/add")
    String producerAddGet(Model model){
        model.addAttribute("producer", new Producer());
        return "/producer/producerAddForm";
    }

    @PostMapping("/add")
    String producerAddPost(Producer producer){
        producerRepository.save(producer);
        return "redirect:/producer/list";
    }

    @GetMapping("/list")
    String producersList(Model model){
        List<Producer> producerList = producerRepository.findAll();
        model.addAttribute("producers", producerList);
        return "/producer/producerList";
    }

    // delete

    // info
}
