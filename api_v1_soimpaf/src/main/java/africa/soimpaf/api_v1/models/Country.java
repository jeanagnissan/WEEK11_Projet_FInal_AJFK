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
import javax.validation.constraints.NotNull;

/**
 * @author digitalci
 *
 */
@Getter
@Setter
@Entity
@Table(name = "countrys")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
    private String name;

	@Column(nullable = false, updatable = false)
	private String slug;

	@CreatedDate
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;

	@OneToMany(targetEntity = Region.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "country_id", referencedColumnName = "id")
	private List<Region> regions;

	public Country() {
		super();
	}

	public Country(long id, String name, String slug, Date created_at, Date updated_at, List<Region> regions) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.regions = regions;
	}

	public Long getId() {
		//return null;
		return  id;
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

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}
}
