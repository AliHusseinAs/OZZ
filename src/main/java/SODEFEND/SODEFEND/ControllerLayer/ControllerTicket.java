package SODEFEND.SODEFEND.ControllerLayer;


import SODEFEND.SODEFEND.RegisterLayer.TicketModel;
import SODEFEND.SODEFEND.ServiceLayer.TicketServInterf;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @CrossOrigin(origins = "127.0.0.1:5500")
    @PutMapping("/api/ticket/update")
    public ResponseEntity<String> updateTicket(@RequestBody Map<String, String> body) {
        Long ticketId = Long.valueOf(body.get("ticketId"));
        String statu = body.get("statu");
        String yorum = body.get("adminYorum");
        return tickServInter.updateTicket(statu, yorum, ticketId);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/api/ticket/getTicket/{userName}") // Username in URL path
    public ResponseEntity<?> getTicket(@PathVariable String userName) {
        return tickServInter.getTicket(userName);
    }
}


