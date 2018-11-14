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
	private String telephone;
	private String photo;
	private String favori_discipline_1;
	private String favori_discipline_2;
	private String favori_discipline_3;
		
	// Creer la clef etrangere
	// Creer la relation entre l'entite Profil et l'entite Utilisateur
	// Cardinalité entre l'entite Profil et l'entite Utilisateur
	// Un profil pour un utilisateur
	@JsonIgnore
	@OneToOne(mappedBy = "utilisateur")
	
	// Creer un tableau Utilisateur nommé utilisateurs
	private List<Utilisateur> utilisateurs;

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

	public String getFavori_discipline_1() {
		return favori_discipline_1;
	}

	public void setFavori_discipline_1(String favori_discipline_1) {
		this.favori_discipline_1 = favori_discipline_1;
	}

	public String getFavori_discipline_2() {
		return favori_discipline_2;
	}

	public void setFavori_discipline_2(String favori_discipline_2) {
		this.favori_discipline_2 = favori_discipline_2;
	}

	public String getFavori_discipline_3() {
		return favori_discipline_3;
	}

	public void setFavori_discipline_3(String favori_discipline_3) {
		this.favori_discipline_3 = favori_discipline_3;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
}