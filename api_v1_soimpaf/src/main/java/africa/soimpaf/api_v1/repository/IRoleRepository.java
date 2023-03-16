package africa.soimpaf.api_v1.repository;


import africa.soimpaf.api_v1.enums.UserRole;
import africa.soimpaf.api_v1.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(UserRole name);
}
