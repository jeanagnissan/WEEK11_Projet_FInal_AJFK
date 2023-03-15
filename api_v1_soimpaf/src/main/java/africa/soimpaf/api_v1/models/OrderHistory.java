/**
 * 
 */
package africa.soimpaf.api_v1.models;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

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
@Table(name = "order_history")
public class OrderHistory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, updatable = false)
	private Double mass;

	@Column(nullable = false, updatable = false)
	private String coded;

	private short order_status;

	@Column(nullable = false, updatable = false)
	private Float commission;

	@Column(nullable = false, updatable = false)
	private Float tax;

	//@Column(nullable = false, updatable = false)
	private String slug;@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")


	@Column(nullable = false, updatable = false)
	private Integer order_id;

	@Column(nullable = false, updatable = false)
	private Integer buyer_id;

	@Column(nullable = false, updatable = false)
	private Integer famer_id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date created_at;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date updated_at;
}
