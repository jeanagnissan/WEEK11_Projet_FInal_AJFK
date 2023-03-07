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
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
    private String name;

	@NotNull(message = "La masse est oligatoire")
    private Double mass_avaibale;

	@NotNull(message = "L'image est oligatoire")
    private String picture;

	@NotNull(message = "Le prix est oligatoire")
    private Float price;

	private short product_status;

	@NotNull(message = "La description est oligatoire")
    private String description;

	private String slug;

	/*
	 * lorsque le champs dispatch est à false, le champ storage_area devient
	 * obligatoire lorsque le champs dispatch est à true, le champ warehouse_id
	 * devient obligatoire
	 */
	private Boolean dispatch;
	private String storage_area;

	@CreatedDate
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;
	
	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private List<Order> orders;

	public Product() {
		super();
	}

	public Product(long id, String name, Double mass_avaibale,
				   String picture, Float price, short product_status,
				   String description, String slug, Boolean dispatch,
				   String storage_area, Date created_at, Date updated_at, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.mass_avaibale = mass_avaibale;
		this.picture = picture;
		this.price = price;
		this.product_status = product_status;
		this.description = description;
		this.slug = slug;
		this.dispatch = dispatch;
		this.storage_area = storage_area;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.orders = orders;
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

	public Double getMass_avaibale() {
		return mass_avaibale;
	}

	public void setMass_avaibale(Double mass_avaibale) {
		this.mass_avaibale = mass_avaibale;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public short getProduct_status() {
		return product_status;
	}

	public void setProduct_status(short product_status) {
		this.product_status = product_status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public Boolean getDispatch() {
		return dispatch;
	}

	public void setDispatch(Boolean dispatch) {
		this.dispatch = dispatch;
	}

	public String getStorage_area() {
		return storage_area;
	}

	public void setStorage_area(String storage_area) {
		this.storage_area = storage_area;
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

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
