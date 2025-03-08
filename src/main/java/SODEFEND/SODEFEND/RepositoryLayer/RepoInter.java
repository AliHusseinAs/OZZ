package SODEFEND.SODEFEND.RepositoryLayer;

import SODEFEND.SODEFEND.RegisterLayer.RegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RepoInter extends JpaRepository<RegisterModel, Long> {
    boolean  existsByUserName(String userName);
    Optional<RegisterModel> deleteByUserName(String userName);
    Optional<RegisterModel> findByUserName(String userName);
    Optional<RegisterModel> findByUserNameAndMail(String userName, String mail);
    Optional<RegisterModel> findByUserName(RegisterModel registerModel);
}
