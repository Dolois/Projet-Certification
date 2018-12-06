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
	private long ProfilId;
    private String sexe;
    private String role;
	private String nom;
	private String prenom;
	private String telephone;
	private String photo;
	private String discipline_1;
	private String discipline_2;
	private String discipline_3;
	private Date date_profil;

    @OneToOne
    private User UserId;
	
	public Profil() { }



	public Profil(long profilId, String sexe, String role, String nom, String prenom, String telephone, String photo,
			String discipline_1, String discipline_2, String discipline_3, Date date_profil, User userId) 
	{
		ProfilId = profilId;
		this.sexe = sexe;
		this.role = role;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.photo = photo;
		this.discipline_1 = discipline_1;
		this.discipline_2 = discipline_2;
		this.discipline_3 = discipline_3;
		this.date_profil = date_profil;
		UserId = userId;
	}

	public long getProfilId() {
		return ProfilId;
	}

	public void setProfilId(long profilId) {
		ProfilId = profilId;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
		return UserId;
	}

	public void setUserId(User userId) {
		UserId = userId;
	}
}