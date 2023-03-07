/**
 * 
 */
package africa.soimpaf.api_v1.models;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;

/**
 * @author digitalci
 *
 */
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

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
	@CreatedDate
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;

	@OneToMany(targetEntity = Notification.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<Notification> notifications;

	@OneToMany(targetEntity = Rating.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<Rating> ratings;

	@OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<Comment> comments;

	public Order() {
		super();
	}

	public Order(long id, Double mass, String coded,
				 short order_status, Float commission, Float tax,
				 String slug, Date created_at, Date updated_at,
				 List<Notification> notifications, List<Rating> ratings, List<Comment> comments) {
		super();
		this.id = id;
		this.mass = mass;
		this.coded = coded;
		this.order_status = order_status;
		this.commission = commission;
		this.tax = tax;
		this.slug = slug;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.notifications = notifications;
		this.ratings = ratings;
		this.comments = comments;
	}

	public Long getId() {
		//return null;
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getMass() {
		return mass;
	}

	public void setMass(Double mass) {
		this.mass = mass;
	}

	public String getCoded() {
		return coded;
	}

	public void setCoded(String coded) {
		this.coded = coded;
	}

	public short getOrder_status() {
		return order_status;
	}

	public void setOrder_status(short order_status) {
		this.order_status = order_status;
	}

	public Float getCommission() {
		return commission;
	}

	public void setCommission(Float commission) {
		this.commission = commission;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
