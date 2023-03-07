/**
 * 
 */
package africa.soimpaf.api_v1.models;

import java.util.Date;
import java.util.List;

import africa.soimpaf.api_v1.enums.EnumSex;
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
@Table(name = "famers")
public class Famer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
    private String name;

	@NotNull(message = "Le prenoms est oligatoire")
    private String first_name;

	@NotNull(message = "L'adresse mail est oligatoire")
    @Column(nullable = false, updatable = true, unique = true)
	private String e_mail;

	private String email_verified_at;

	@NotNull(message = "Le mot de passe est oligatoire")
    private String password;

	private String password_confirm;

	@Column(nullable = false, updatable = false)
	private String slug;

	private String picture;
	private String theme;

	@NotNull(message = "Le champ sexe est oligatoire")
    private EnumSex sexe;

	@NotNull(message = "Le numero de telephone est oligatoire")
    private String number_one;

	private String number_twoo;
	private Boolean famer_status;
	private Date date_of_birth;

	@CreatedDate
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;

	/*
	 * le champ famer_id se remplir automatique en prenamt l'id de l'agriculteur
	 * connecté
	 */
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "famer_id", referencedColumnName = "id")
	private List<Product> produts;

	@OneToMany(targetEntity = Notification.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "famer_id", referencedColumnName = "id")
	private List<Notification> notifications;

	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "famer_id", referencedColumnName = "id")
	private List<Order> orders;

	public Famer() {
		super();
	}

	public Famer(long id, String name, String first_name,
				 String e_mail, String email_verified_at, String password,
				 String password_confirm, String slug, String picture,
				 String theme, EnumSex sexe, String number_one,
				 String number_twoo, Boolean famer_status,
				 Date date_of_birth, Date created_at, Date updated_at,
				 List<Product> produts, List<Notification> notifications, List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.first_name = first_name;
		this.e_mail = e_mail;
		this.email_verified_at = email_verified_at;
		this.password = password;
		this.password_confirm = password_confirm;
		this.slug = slug;
		this.picture = picture;
		this.theme = theme;
		this.sexe = sexe;
		this.number_one = number_one;
		this.number_twoo = number_twoo;
		this.famer_status = famer_status;
		this.date_of_birth = date_of_birth;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.produts = produts;
		this.notifications = notifications;
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getEmail_verified_at() {
		return email_verified_at;
	}

	public void setEmail_verified_at(String email_verified_at) {
		this.email_verified_at = email_verified_at;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword_confirm() {
		return password_confirm;
	}

	public void setPassword_confirm(String password_confirm) {
		this.password_confirm = password_confirm;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public EnumSex getSexe() {
		return sexe;
	}

	public void setSexe(EnumSex sexe) {
		this.sexe = sexe;
	}

	public String getNumber_one() {
		return number_one;
	}

	public void setNumber_one(String number_one) {
		this.number_one = number_one;
	}

	public String getNumber_twoo() {
		return number_twoo;
	}

	public void setNumber_twoo(String number_twoo) {
		this.number_twoo = number_twoo;
	}

	public Boolean getFamer_status() {
		return famer_status;
	}

	public void setFamer_status(Boolean famer_status) {
		this.famer_status = famer_status;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
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

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
