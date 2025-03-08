package SODEFEND.SODEFEND.RepositoryLayer;

import SODEFEND.SODEFEND.RegisterLayer.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<TicketModel, Long> {
}
