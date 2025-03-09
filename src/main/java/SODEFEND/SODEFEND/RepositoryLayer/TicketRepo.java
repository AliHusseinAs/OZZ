package SODEFEND.SODEFEND.RepositoryLayer;

import SODEFEND.SODEFEND.RegisterLayer.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TicketRepo extends JpaRepository<TicketModel, Long> {
    @Query("SELECT t FROM TicketModel t WHERE t.user.userName = :userName")
    List<TicketModel> findByUserName(@Param("userName") String userName);
}
