package pl.jakubtuminski.ticket;

import pl.jakubtuminski.client.Client;
import pl.jakubtuminski.machine.Machine;
import pl.jakubtuminski.user.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private boolean warranty;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "machine_id")
    private Machine machine;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private User manager;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "technician_id")
    private User technician;
    private Long distance;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public User getTechnician() {
        return technician;
    }

    public void setTechnician(User technician) {
        this.technician = technician;
    }
}
