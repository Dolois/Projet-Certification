package co.simplon.certification.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import net.minidev.json.annotate.JsonIgnore;

@Entity
public class Profil 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	private String nom;
	private String prenom;
	private String sexe;
	private String role;
	private String telephone;
	private String photo;
	private String discipline_1;
	private String discipline_2;
	private String discipline_3;
	private long ref_utilisateur;
	private long ref_discipline;
	
	public Profil() { }



	public Profil(long id, String nom, String prenom, String sexe, String role, String telephone, String photo,
			String discipline_1, String discipline_2, String discipline_3, long ref_utilisateur, long ref_discipline) 
	{
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.role = role;
		this.telephone = telephone;
		this.photo = photo;
		this.discipline_1 = discipline_1;
		this.discipline_2 = discipline_2;
		this.discipline_3 = discipline_3;
		this.ref_utilisateur = ref_utilisateur;
		this.ref_discipline = ref_discipline;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getRef_utilisateur() {
		return ref_utilisateur;
	}

	public void setRef_utilisateur(long ref_utilisateur) {
		this.ref_utilisateur = ref_utilisateur;
	}

	public long getRef_discipline() {
		return ref_discipline;
	}

	public void setRef_discipline(long ref_discipline) {
		this.ref_discipline = ref_discipline;
	}
}