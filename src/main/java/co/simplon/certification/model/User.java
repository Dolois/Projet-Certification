package co.simplon.certification.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
public class User 
{
	/** Creer la cle primaire id de User */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
	
	/** The profil. */
	@OneToOne(mappedBy = "user")
	private Profil profil;
	
	/**
	 * Instantiates a new user.
	 */
	public User() {}

	/**
	 * Instantiates a new user.
	 *
	 * @param id the id
	 * @param email the email
	 * @param password the password
	 * @param profil the profil
	 */
	public User(long id, String email, String password, Profil profil) 
	{
		this.id = id;
		this.email = email;
		this.password = password;
		this.profil = profil;
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
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the profil.
	 *
	 * @return the profil
	 */
	public Profil getProfil() {
		return profil;
	}

	/**
	 * Sets the profil.
	 *
	 * @param profil the new profil
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
}