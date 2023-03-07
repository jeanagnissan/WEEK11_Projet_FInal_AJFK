/**
 * 
 */
package africa.soimpaf.api_v1.models;

import java.util.Date;

import africa.soimpaf.api_v1.enums.EnumNotification;
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
@Table(name = "notifications")
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull(message = "Le nom est oligatoire")
    private EnumNotification transmitter_type;
	private Boolean read;
	@Column(nullable = false, updatable = false)
	private String slug;
	@CreatedDate
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;

	public Notification() {
		super();
	}
	public Notification(long id, EnumNotification transmitter_type,
						Boolean read, String slug, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.transmitter_type = transmitter_type;
		this.read = read;
		this.slug = slug;
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

	public EnumNotification getTransmitter_type() {
		return transmitter_type;
	}

	public void setTransmitter_type(EnumNotification transmitter_type) {
		this.transmitter_type = transmitter_type;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
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
