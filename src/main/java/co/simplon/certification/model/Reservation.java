package co.simplon.certification.model;

import java.sql.Date;
import java.sql.Time;
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
public class Reservation 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
		
	private Date date;
	private Time heure;
	private int duree;
		
	// Creer la clef etrangere
	// Creer la relation entre l'entite Reservation et l'entite Activite
	// Cardinalité entre l'entite Reservation et l'entite Activite
	// Des reservations pour des activites sportives
	@ManyToMany(mappedBy = "activite")
		
	// Creer un tableau d'Activite nommé activites 
	private List<Activite> activites;
		
	// Creer la clef etrangere
	// Creer la relation entre l'entite Reservation et l'entite Utilisateur 
	// Cardinalité entre l'entite Reservation et l'entite Utilisateur
	// Une reservation pour un utilisateur
	@JsonIgnore
	@OneToOne(mappedBy = "utilisateur")
		
	// Creer un tableau d'Utilisateur nommé utilisateurs 
	private List<Utilisateur> utilisateurs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHeure() {
		return heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
}