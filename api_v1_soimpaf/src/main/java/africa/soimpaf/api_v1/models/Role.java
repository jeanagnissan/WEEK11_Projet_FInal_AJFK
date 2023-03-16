package africa.soimpaf.api_v1.models;

import africa.soimpaf.api_v1.enums.UserRole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Role extends AbstractEntity implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", length = 20)
    private UserRole name;

    public static Role roleAdmin() {
        Role roleAdmin = new Role();
        roleAdmin.setName(UserRole.ROLE_ADMIN);
        return roleAdmin;
    }

    public static Role roleBuyer() {
        Role roleBuyer = new Role();
        roleBuyer.setName(UserRole.ROLE_BUYER);
        return roleBuyer;
    }

    public static Role roleFamer() {
        Role roleFamer = new Role();
        roleFamer.setName(UserRole.ROLE_FAMER);
        return roleFamer;
    }

    @Override
    public String getAuthority() {
        return this.getName().toString();
    }
}
