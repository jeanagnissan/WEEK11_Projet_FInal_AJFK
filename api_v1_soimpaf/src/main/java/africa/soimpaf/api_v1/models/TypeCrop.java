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
 */
@Getter
@Setter
@Entity
@Table(name = "type_crops")
public class TypeCrop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
    private String name;

	private String slug;

	@CreatedDate
	private Date created_at;
	@UpdateTimestamp
	private Date updated_at;

	@NotNull(message = "Le type de culture est oligatoire")
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "type_crop_id", referencedColumnName = "id")
	private List<Product> products;

	public TypeCrop() {
		super();
	}

	public TypeCrop(long id, String name, String slug,
					Date created_at, Date updated_at,
					List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.products = products;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
