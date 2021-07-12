package pl.jakubtuminski.ticket;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.jakubtuminski.client.ClientRepository;
import pl.jakubtuminski.distance.GoogleDistanceMatrixDataClient;
import pl.jakubtuminski.machine.Machine;
import pl.jakubtuminski.machine.MachineRepository;
import pl.jakubtuminski.user.UserRepository;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ClientRepository clientRepository;
    private final MachineRepository machineRepository;
    private final UserRepository userRepository;
    private final GoogleDistanceMatrixDataClient googleDistanceMatrixDataClient;

    public TicketService(TicketRepository ticketRepository, ClientRepository clientRepository, MachineRepository machineRepository, UserRepository userRepository, GoogleDistanceMatrixDataClient googleDistanceMatrixDataClient) {
        this.ticketRepository = ticketRepository;
        this.clientRepository = clientRepository;
        this.machineRepository = machineRepository;
        this.userRepository = userRepository;
        this.googleDistanceMatrixDataClient = googleDistanceMatrixDataClient;
    }

    @Transactional
    public void saveTicket(TicketDto ticketDto, Long clientId, Long machineId, Long managerId, Long technicianId){
        Ticket ticket = new Ticket();
        String machineAddress = machineRepository.findMachineById(machineId).getAddress();
        String technicianAddress = userRepository.findUserById(technicianId).getAddress();
        ticket.setDescription(ticketDto.getDescription());
        ticket.setWarranty(ticketDto.isWarranty());
        ticketRepository.save(ticket);
        ticket.setClient(clientRepository.findClientById(clientId));
        ticket.setMachine(machineRepository.findMachineById(machineId));
        ticket.setManager(userRepository.findUserById(managerId));
        ticket.setTechnician(userRepository.findUserById(technicianId));
        ticket.setDistance(Long.parseLong(googleDistanceMatrixDataClient.getMapResponse(technicianAddress, machineAddress).getRows().get(0).getElements().get(0).getDistance().getValue()));
        ticketRepository.save(ticket);
    }
}
