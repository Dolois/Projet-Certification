package co.simplon.certification.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	private String email;
	private String password;
	
	@OneToOne
	private Profil profilId;
	
	public User() { }

	public User(long userId, String email, String password, Profil profilId) 
	{
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.profilId = profilId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Profil getProfilId() {
		return profilId;
	}

	public void setProfilId(Profil profilId) {
		this.profilId = profilId;
	}
}