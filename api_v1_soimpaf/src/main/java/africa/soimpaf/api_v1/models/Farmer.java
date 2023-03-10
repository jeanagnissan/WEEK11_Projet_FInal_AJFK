/**
 * 
 */
package africa.soimpaf.api_v1.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import africa.soimpaf.api_v1.enums.EnumSex;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author digitalci
 *
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "farmers")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Farmer implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
    private String name;

	@NotNull(message = "Le prenoms est oligatoire")
    private String first_name;

	@NotNull(message = "L'adresse mail est oligatoire")
    @Column(nullable = false, updatable = true, unique = true)
	private String e_mail;

	private Date email_verified_at;

	@NotNull(message = "Le mot de passe est oligatoire")
    private String password;

	private String password_confirm;

	@Column(nullable = false, updatable = false)
	private String slug;

	private String picture;
	private String theme;

	@NotNull(message = "Le champ sexe est oligatoire")
    private EnumSex sexe;

	@NotNull(message = "Le numero de telephone est oligatoire")
	@Column(updatable = true, unique = true)
	private String number_one;

	@Column(updatable = true, unique = true)
	private String number_twoo;

	private short famer_status;
	private Date date_of_birth;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date updated_at;

	@OneToMany(mappedBy = "farmer" , cascade = CascadeType.ALL)
	@JsonIdentityReference(alwaysAsId = true)
	private List<Product> product;

	@OneToMany(mappedBy = "farmer" , cascade = CascadeType.ALL)
	@JsonIdentityReference(alwaysAsId = true)
	private List<Notification> notification;
}
