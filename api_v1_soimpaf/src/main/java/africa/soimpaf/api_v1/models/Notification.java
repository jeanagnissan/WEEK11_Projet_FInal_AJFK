/**
 * 
 */
package africa.soimpaf.api_v1.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import africa.soimpaf.api_v1.enums.EnumNotification;
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
@Table(name = "notifications")
public class Notification  implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private EnumNotification transmitter_type;

	private Boolean farmer_as_read;

	private Boolean buyer_as_read;

	private Boolean admin_as_read;

	private Boolean wadmin_as_read;

	//@Column(nullable = false, updatable = false)
	private String slug;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date updated_at;

	@ManyToOne
	@JsonIdentityReference(alwaysAsId = true)
	private Buyer buyer;

	@ManyToOne
	@JsonIdentityReference(alwaysAsId = true)
	private Order order;

	@ManyToOne
	@JsonIdentityReference(alwaysAsId = true)
	private Farmer farmer;
}
