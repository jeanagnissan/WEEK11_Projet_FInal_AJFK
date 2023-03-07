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
@Table(name = "buyers")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
    private String name;

	@NotNull(message = "Le prenoms est oligatoire")
    private String first_name;

	private String e_mail;

	private String email_verified_at;

	@NotNull(message = "Le mot de passe est oligatoire")
    private String password;

	@NotNull(message = "Le numero de telephone est oligatoire")
    private String number_one;

	private EnumSex sexe;

	private String slug;

	private char Buyer_status;

	private String theme;

	private String picture;

	@CreatedDate
	private Date created_at;

	@UpdateTimestamp
	private Date updated_at;
	@OneToMany(targetEntity = Notification.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private List<Notification> notifications;

	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private List<Order> orders;

	@OneToMany(targetEntity = Rating.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private List<Rating> ratings;

	@OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "buyer_id", referencedColumnName = "id")
	private List<Comment> comments;

	public Buyer() {
		super();
	}

	public Buyer(long id, String name, String first_name, String e_mail,
				 String email_verified_at, String password, String number_one,
				 EnumSex sexe, String slug, char buyer_status, String theme,
				 String picture, Date created_at, Date updated_at,
				 List<Notification> notifications, List<Order> orders,
				 List<Rating> ratings, List<Comment> comments) {
		super();
		this.id = id;
		this.name = name;
		this.first_name = first_name;
		this.e_mail = e_mail;
		this.email_verified_at = email_verified_at;
		this.password = password;
		this.number_one = number_one;
		this.sexe = sexe;
		this.slug = slug;
		Buyer_status = buyer_status;
		this.theme = theme;
		this.picture = picture;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.notifications = notifications;
		this.orders = orders;
		this.ratings = ratings;
		this.comments = comments;
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

	public String getNumber_one() {
		return number_one;
	}

	public void setNumber_one(String number_one) {
		this.number_one = number_one;
	}

	public Enum getSexe() {
		return sexe;
	}

	public void setSexe(EnumSex sexe) {
		this.sexe = sexe;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public char getBuyer_status() {
		return Buyer_status;
	}

	public void setBuyer_status(char buyer_status) {
		Buyer_status = buyer_status;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
