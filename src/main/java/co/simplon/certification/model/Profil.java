package co.simplon.certification.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Profil 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	private String firstname;
	private String city;
	private String phone;
    private String role;
	private String photo;
	private String discipline_1;
	private String discipline_2;
	private String discipline_3;
	private Date dateProfil;

    @OneToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;
	
	public Profil() { }

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

	public long getId() {
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

	public Date getDateProfil() {
		return dateProfil;
	}

	public void setDateProfil(Date dateProfil) {
		this.dateProfil = dateProfil;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}