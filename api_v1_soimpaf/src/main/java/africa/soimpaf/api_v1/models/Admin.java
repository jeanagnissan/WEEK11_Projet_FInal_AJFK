/**
 * 
 */
package africa.soimpaf.api_v1.models;

import java.util.Date;

import africa.soimpaf.api_v1.enums.EnumSex;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author digitalci
 *
 */
@Getter
@Setter
@Entity
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "Le nom est oligatoire")
	private String name;

	@NotNull(message = "Le prenoms est oligatoire")
	private String first_name;

	@Column(nullable = false, updatable = true, unique = true)
	private String e_mail;

	@NotNull(message = "Le mot de passe est oligatoire")
	private String password;

	@Column(nullable = false, updatable = false)
	private String slug;

	private EnumSex sexe;

	private String picture;
	private short admin_status;
	private String theme;

	@NotNull(message = "Le numero de telephone est oligatoire")
	private String number_one;

	//@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date created_at;

	//@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP",insertable = false, updatable = false)
	private Date updated_at;

	public Admin() {
		super();
	}

	public Admin(long id, String name, String first_name, EnumSex sexe, String e_mail, String password,
				 String slug, String picture, short admin_status, String theme,
				 String number_one, Date created_at, Date updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.sexe = sexe;
		this.first_name = first_name;
		this.e_mail = e_mail;
		this.password = password;
		this.slug = slug;
		this.picture = picture;
		this.admin_status = admin_status;
		this.theme = theme;
		this.number_one = number_one;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public short getAdmin_status() {
		return admin_status;
	}

	public void setAdmin_status(short admin_status) {
		this.admin_status = admin_status;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getNumber_one() {
		return number_one;
	}

	public void setNumber_one(String number_one) {
		this.number_one = number_one;
	}

	public Date getCreated_at() {
		return created_at  ;
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
