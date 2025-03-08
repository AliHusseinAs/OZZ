package SODEFEND.SODEFEND.ServiceLayer;


import SODEFEND.SODEFEND.RegisterLayer.RegisterModel;
import SODEFEND.SODEFEND.RegisterLayer.TicketModel;
import SODEFEND.SODEFEND.RepositoryLayer.RepoInter;
import SODEFEND.SODEFEND.RepositoryLayer.TicketRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ServiceTicket implements TicketServInterf{
    private final TicketRepo tickRepo;
    private final RepoInter repoInter;
    //private final RegisterModel registerModel;
    public ServiceTicket(TicketRepo tickRepo, RepoInter repoInter) {
        this.tickRepo = tickRepo;
        this.repoInter = repoInter;
    }


    @Override
    public void sendTicket(TicketModel ticketModel) {
//        if (repoInter.findByUserName(ticketModel.getUser()) == null) {
//            throw new IllegalArgumentException("User must be provided");
//        }
//        tickRepo.save(ticketModel);
        System.out.println("Print");
        System.out.println(ticketModel.getUser().getUserName());
        RegisterModel user = repoInter.findByUserName(ticketModel.getUser().getUserName())
                .orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("USer");
        System.out.println(user.getUserName());
        ticketModel.setUser(user);
        tickRepo.save(ticketModel);
    }
}

