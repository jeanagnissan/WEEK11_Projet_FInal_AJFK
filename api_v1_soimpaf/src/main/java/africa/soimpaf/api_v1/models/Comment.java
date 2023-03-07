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
import javax.validation.constraints.NotNull;


/**
 * @author digitalci
 *
 */
@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Boolean comment_status;

	@NotNull(message = "Le message est oligatoire")
    private String message;

	private String slug;

	@CreatedDate
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;

	public Comment() {
		super();
	}

	public Comment(long id, Boolean comment_status, String message,
				   String slug, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.comment_status = comment_status;
		this.message = message;
		this.slug = slug;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Long getId() {
		return  id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getComment_status() {
		return comment_status;
	}

	public void setComment_status(Boolean comment_status) {
		this.comment_status = comment_status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
