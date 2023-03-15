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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "buyers")
public class Buyer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
    private String name;

	@NotNull(message = "Le prenoms est oligatoire")
    private String first_name;

	@Column(nullable = false, updatable = true, unique = true)
	private String e_mail;

	private Date email_verified_at;

	@NotNull(message = "Le mot de passe est oligatoire")
    private String password;

	@NotNull(message = "Le numero de telephone est oligatoire")
	@Column(updatable = true, unique = true)
	private String number_one;

	private EnumSex sexe;

	private String slug;

	private short Buyer_status;

	private String theme;

	private String picture;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date updated_at;

	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
	@JsonIdentityReference(alwaysAsId = true)
	private List<Notification> notification;

	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
	@JsonIdentityReference(alwaysAsId = true)
	private List<Order> order;
}
