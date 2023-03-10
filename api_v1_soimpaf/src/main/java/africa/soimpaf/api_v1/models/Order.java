/**
 * 
 */
package africa.soimpaf.api_v1.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

/**
 * @author
 */
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order implements Serializable {
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

	@Column(nullable = false, updatable = false)
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
	private Product product;

	@OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
	@JsonIdentityReference(alwaysAsId = true)
	private List<Notification> notification;

	@OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
	@JsonIdentityReference(alwaysAsId = true)
	private List<Rating> rating;

	@OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
	@JsonIdentityReference(alwaysAsId = true)
	private List<Comment> comment;

}
