package SODEFEND.SODEFEND.ServiceLayer;


import SODEFEND.SODEFEND.RegisterLayer.TicketModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TicketServInterf {
    void sendTicket(TicketModel ticketModel);
    ResponseEntity<String> updateTicket(String statu, String Yourm, Long ticketID);
    ResponseEntity<?> getTicket(String userName);
}
