package co.simplon.certification.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import net.minidev.json.annotate.JsonIgnore;

@Entity
public class Utilisateur 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nom;
	private String prenom;
	private String email;
		
	// Creer la clef etrangere
	// Creer la relation entre l'entite Utilisateur et l'entite Reservation
	// Cardinalité entre l'entite Utilisateur et l'entite Reservation
	// Deux utilisateurs peuvent reserver sur le meme creneau (deux joueurs de tennis)
	@JsonIgnore
	@ManyToMany(mappedBy = "reservation")
		
	// Creer un tableau Reservation nommé reservations
	private List<Reservation> reservations;

	// Creer la clef etrangere
	// Creer la relation entre l'entite Utilisateur et l'entite Profil
	// Cardinalité entre l'entite Utilisateur et l'entite Profil
	// Un utilisateur pour un profil
	@JsonIgnore
	@OneToOne(mappedBy = "profil")
		
	// Creer un tableau Profil nommé profils
	private List<Profil> profils;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public List<Profil> getProfils() {
		return profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}
}