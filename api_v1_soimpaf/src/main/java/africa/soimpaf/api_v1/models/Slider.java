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
 */
@Getter
@Setter
@Entity
@Table(name = "sliders")
public class Slider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
    private String name;

	private String picture;
	private short slider_status;

	@CreatedDate
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;

	@Column(nullable = false, updatable = false)
	private String slug;

	public Slider() {
		super();
	}
	public Slider(long id, String name, String picture,
				  short slider_status, Date created_at,
				  Date updated_at, String slug) {
		super();
		this.id = id;
		this.name = name;
		this.picture = picture;
		this.slider_status = slider_status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.slug = slug;
	}

	public Long getId() {
		//return null;
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public short getSlider_status() {
		return slider_status;
	}

	public void setSlider_status(short slider_status) {
		this.slider_status = slider_status;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}
}
