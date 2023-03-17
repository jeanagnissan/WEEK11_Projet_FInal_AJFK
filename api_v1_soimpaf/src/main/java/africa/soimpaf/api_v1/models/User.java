package africa.soimpaf.api_v1.models;

import africa.soimpaf.api_v1.enums.EnumSex;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User extends AbstractEntity {

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Le champ firstname est obligatoire")
    @NotBlank(message = "Le champ firstname ne peut etre vide")
    @Column(name = "firstname")
    private String firstname;

    @NotNull(message = "Le champ lastname est obligatoire")
    @NotBlank(message = "Le champ lastname ne peut etre vide")
    @Column(name = "lastname")
    private String lastname;

    @NotNull(message = "Le champ email est obligatoire")
    @NotBlank(message = "Le champ email ne peut etre vide")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;*/


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
	private String name;

	@NotNull(message = "Le prenoms est oligatoire")
	private String first_name;

	@NotNull(message = "Le champ firstname est obligatoire")
	@NotBlank(message = "Le champ firstname ne peut etre vide")
	@Column(name = "firstname")
	private String firstname;

	@Column(nullable = false, updatable = true, unique = true)
	private String email;

	@NotNull(message = "Le mot de passe est oligatoire")
	private String password;

	//@Column(nullable = false, updatable = false)
	private String slug;

	private EnumSex sexe;

	private String picture;
	private short admin_status;
	private String theme;

	@ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private Role role;

	@NotNull(message = "Le numero de telephone est oligatoire")
	@Column(updatable = true, unique = true)
	private String number_one;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date created_at;

    public static User superAdmin(Optional<Role> role, BCryptPasswordEncoder bCryptPasswordEncoder) throws Exception {
        User user = new User();
        user.setName("Melissa");
        user.setFirst_name("aaaa");
        user.setEmail("hello@gmail.com");
        if (!(bCryptPasswordEncoder == null)) {
            user.setPassword(bCryptPasswordEncoder.encode("helloworld"));
        }
        user.setRole(role.get());
        return user;
    }
}
