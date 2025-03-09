package SODEFEND.SODEFEND.ServiceLayer;


import SODEFEND.SODEFEND.RegisterLayer.RegisterModel;
import SODEFEND.SODEFEND.RegisterLayer.TicketModel;
import SODEFEND.SODEFEND.RepositoryLayer.RepoInter;
import SODEFEND.SODEFEND.RepositoryLayer.TicketRepo;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class ServiceTicket implements TicketServInterf{
    private final TicketRepo tickRepo;
    private final RepoInter repoInter;
    public ServiceTicket(TicketRepo tickRepo, RepoInter repoInter) {
        this.tickRepo = tickRepo;
        this.repoInter = repoInter;
    }


    @Override
    public void sendTicket(TicketModel ticketModel) {
        RegisterModel user = repoInter.findByUserName(ticketModel.getUser().getUserName())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ticketModel.setUser(user);
        tickRepo.save(ticketModel);
    }

    @Override
    public ResponseEntity<String> updateTicket(String statu, String Yorum, Long ticketID) {
        Optional<TicketModel> ticketModel = tickRepo.findById(ticketID);
        if(ticketModel.isEmpty()) {
            return new ResponseEntity<>("Ticket bulunamadı", HttpStatus.NOT_FOUND);
        }
        if(statu.isEmpty() || Yorum.isEmpty() ) {
            return new ResponseEntity<>("Statü veya Admin Yorumu Boş Bırakılmaz", HttpStatus.BAD_REQUEST);
        }
        TicketModel ticketModel1 = ticketModel.get();
        ticketModel1.setAdminYorum(Yorum);
        ticketModel1.setStatu(statu);
        String userName = ticketModel1.getUser().getUserName();
        tickRepo.save(ticketModel1);
        return new ResponseEntity<>(userName + " kullanıcı isimli " + ticketID + " ticketID'li ticket güncellendi", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getTicket(String userName) {
        List<TicketModel> tickets = tickRepo.findByUserName(userName);
        if (tickets.isEmpty()) {
            Map<String, String> errorResponse = Map.of("error", "User not found: " + userName);
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }
}

