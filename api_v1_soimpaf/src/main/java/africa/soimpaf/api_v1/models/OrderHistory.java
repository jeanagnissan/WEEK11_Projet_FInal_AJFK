/**
 * 
 */
package africa.soimpaf.api_v1.models;

import java.util.Date;
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
@Table(name = "order_history")
public class OrderHistory {

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

	@Column(nullable = false, updatable = false)
	private Integer order_id;

	@Column(nullable = false, updatable = false)
	private Integer buyer_id;

	@Column(nullable = false, updatable = false)
	private Integer famer_id;

	@CreatedDate
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;

	public OrderHistory() {
		super();
	}

	public OrderHistory(long id, Double mass, String coded, short order_status,
						Float commission, Float tax, String slug, Integer order_id,
						Integer buyer_id, Integer famer_id, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.mass = mass;
		this.coded = coded;
		this.order_status = order_status;
		this.commission = commission;
		this.tax = tax;
		this.slug = slug;
		this.order_id = order_id;
		this.buyer_id = buyer_id;
		this.famer_id = famer_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
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

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(Integer buyer_id) {
		this.buyer_id = buyer_id;
	}

	public Integer getFamer_id() {
		return famer_id;
	}

	public void setFamer_id(Integer famer_id) {
		this.famer_id = famer_id;
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
}
