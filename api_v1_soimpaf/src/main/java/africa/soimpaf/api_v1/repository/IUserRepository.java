package africa.soimpaf.api_v1.repository;

import  africa.soimpaf.api_v1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM users  WHERE email =:email ", nativeQuery = true)
    User findUserByEmail(String email);
    Optional<User> findByFirstnameOrEmail(String firstname, String email);

    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}
