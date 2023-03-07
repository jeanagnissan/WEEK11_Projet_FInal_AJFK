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
 */
@Getter
@Setter
@Entity
@Table(name = "ratings")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Boolean rating_status;
	private short value;

	private String slug;

	@CreatedDate
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;

	public Rating() {
		super();
	}

	public Rating(long id, Boolean rating_status, short value,
				  String slug, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.rating_status = rating_status;
		this.value = value;
		this.slug = slug;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Long getId() {
		//return null;
		return  id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getRating_status() {
		return rating_status;
	}

	public void setRating_status(Boolean rating_status) {
		this.rating_status = rating_status;
	}

	public short getValue() {
		return value;
	}

	public void setValue(short value) {
		this.value = value;
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
}
