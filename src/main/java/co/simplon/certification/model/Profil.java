package co.simplon.certification.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Profil 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long profilId;
	private String name;
	private String firstname;
	private String city;
	private String phone;
    private String role;
	private String photo;
	private String discipline_1;
	private String discipline_2;
	private String discipline_3;
	private Date date_profil;

    @OneToOne
    private User userId;
	
	public Profil() { }

	public Profil(long profilId, String name, String firstname, String city, String phone, String role, String photo,
			String discipline_1, String discipline_2, String discipline_3, Date date_profil, User userId) 
	{
		this.profilId = profilId;
		this.name = name;
		this.firstname = firstname;
		this.city = city;
		this.phone = phone;
		this.role = role;
		this.photo = photo;
		this.discipline_1 = discipline_1;
		this.discipline_2 = discipline_2;
		this.discipline_3 = discipline_3;
		this.date_profil = date_profil;
		this.userId = userId;
	}

	public long getProfilId() {
		return profilId;
	}

	public void setProfilId(long profilId) {
		this.profilId = profilId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDiscipline_1() {
		return discipline_1;
	}

	public void setDiscipline_1(String discipline_1) {
		this.discipline_1 = discipline_1;
	}

	public String getDiscipline_2() {
		return discipline_2;
	}

	public void setDiscipline_2(String discipline_2) {
		this.discipline_2 = discipline_2;
	}

	public String getDiscipline_3() {
		return discipline_3;
	}

	public void setDiscipline_3(String discipline_3) {
		this.discipline_3 = discipline_3;
	}

	public Date getDate_profil() {
		return date_profil;
	}

	public void setDate_profil(Date date_profil) {
		this.date_profil = date_profil;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
}