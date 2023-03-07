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
@Table(name = "warehouses")
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
    private String name;

	private String coded;

	@Column(nullable = false, updatable = false)
	private String slug;

	@NotNull(message = "L'heure d'ouverture  est oligatoire")
    private Date opening_time;

	@NotNull(message = "L'heure de fermeture est oligatoire")
    private Date closing_time;

	private Double localisation;

	private Boolean waherouse_status;

	@CreatedDate
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;

	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "waherouse_id", referencedColumnName = "id")
	private List<Product> produts;

	public Warehouse() {
		super();
	}

	public Warehouse(long id, String name, String coded,
					 String slug, Date opening_time, Date closing_time,
					 Double localisation, Boolean waherouse_status, Date created_at,
					 Date updated_at, List<Product> produts) {
		super();
		this.id = id;
		this.name = name;
		this.coded = coded;
		this.slug = slug;
		this.opening_time = opening_time;
		this.closing_time = closing_time;
		this.localisation = localisation;
		this.waherouse_status = waherouse_status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.produts = produts;
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

	public String getCoded() {
		return coded;
	}

	public void setCoded(String coded) {
		this.coded = coded;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Date getOpening_time() {
		return opening_time;
	}

	public void setOpening_time(Date opening_time) {
		this.opening_time = opening_time;
	}

	public Date getClosing_time() {
		return closing_time;
	}

	public void setClosing_time(Date closing_time) {
		this.closing_time = closing_time;
	}

	public Double getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Double localisation) {
		this.localisation = localisation;
	}

	public Boolean getWaherouse_status() {
		return waherouse_status;
	}

	public void setWaherouse_status(Boolean waherouse_status) {
		this.waherouse_status = waherouse_status;
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

	public List<Product> getProduts() {
		return produts;
	}

	public void setProduts(List<Product> produts) {
		this.produts = produts;
	}



}
