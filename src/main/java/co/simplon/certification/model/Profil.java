package co.simplon.certification.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Profil.
 */
@Entity
public class Profil 
{
	/** Creer la cle primaire id de Profil */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/** The name. */
	private String name;
	
	/** The firstname. */
	private String firstname;
	
	/** The city. */
	private String city;
	
	/** The phone. */
	private String phone;
    
    /** The role. */
    private String role;
	
	/** The photo. */
	private String photo;
	
	/** The discipline 1. */
	private String discipline_1;
	
	/** The discipline 2. */
	private String discipline_2;
	
	/** The discipline 3. */
	private String discipline_3;
	
	/** The date profil. */
	private Date dateProfil;

    /** The user. */
    @OneToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;
	
	/**
	 * Instantiates a new profil.
	 */
	public Profil() { }

	/**
	 * Instantiates a new profil.
	 *
	 * @param id the id
	 * @param name the name
	 * @param firstname the firstname
	 * @param city the city
	 * @param phone the phone
	 * @param role the role
	 * @param photo the photo
	 * @param discipline_1 the discipline 1
	 * @param discipline_2 the discipline 2
	 * @param discipline_3 the discipline 3
	 * @param dateProfil the date profil
	 * @param user the user
	 */
	public Profil(long id, String name, String firstname, String city, String phone, String role, String photo,
			String discipline_1, String discipline_2, String discipline_3, Date dateProfil, User user) 
	{
		this.id = id;
		this.name = name;
		this.firstname = firstname;
		this.city = city;
		this.phone = phone;
		this.role = role;
		this.photo = photo;
		this.discipline_1 = discipline_1;
		this.discipline_2 = discipline_2;
		this.discipline_3 = discipline_3;
		this.dateProfil = dateProfil;
		this.user = user;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Gets the photo.
	 *
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * Sets the photo.
	 *
	 * @param photo the new photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * Gets the discipline 1.
	 *
	 * @return the discipline 1
	 */
	public String getDiscipline_1() {
		return discipline_1;
	}

	/**
	 * Sets the discipline 1.
	 *
	 * @param discipline_1 the new discipline 1
	 */
	public void setDiscipline_1(String discipline_1) {
		this.discipline_1 = discipline_1;
	}

	/**
	 * Gets the discipline 2.
	 *
	 * @return the discipline 2
	 */
	public String getDiscipline_2() {
		return discipline_2;
	}

	/**
	 * Sets the discipline 2.
	 *
	 * @param discipline_2 the new discipline 2
	 */
	public void setDiscipline_2(String discipline_2) {
		this.discipline_2 = discipline_2;
	}

	/**
	 * Gets the discipline 3.
	 *
	 * @return the discipline 3
	 */
	public String getDiscipline_3() {
		return discipline_3;
	}

	/**
	 * Sets the discipline 3.
	 *
	 * @param discipline_3 the new discipline 3
	 */
	public void setDiscipline_3(String discipline_3) {
		this.discipline_3 = discipline_3;
	}

	/**
	 * Gets the date profil.
	 *
	 * @return the date profil
	 */
	public Date getDateProfil() {
		return dateProfil;
	}

	/**
	 * Sets the date profil.
	 *
	 * @param dateProfil the new date profil
	 */
	public void setDateProfil(Date dateProfil) {
		this.dateProfil = dateProfil;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(User user) {
		this.user = user;
	}
}