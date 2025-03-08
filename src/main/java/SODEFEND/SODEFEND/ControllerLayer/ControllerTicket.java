package SODEFEND.SODEFEND.ControllerLayer;


import SODEFEND.SODEFEND.RegisterLayer.TicketModel;
import SODEFEND.SODEFEND.ServiceLayer.TicketServInterf;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ControllerTicket {
    private final TicketServInterf tickServInter;

    public ControllerTicket(TicketServInterf tickServInter) {
        this.tickServInter = tickServInter;
    }

    @CrossOrigin(origins = "127.0.0.1:5500")
    @PostMapping("/api/ticket/addTicket")
    public ResponseEntity<String> addTicker(@RequestBody TicketModel ticketModel) {
        try {
            tickServInter.sendTicket(ticketModel);
            return new ResponseEntity<>("Ticket Gönderildi", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}


