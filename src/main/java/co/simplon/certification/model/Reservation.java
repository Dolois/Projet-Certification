package co.simplon.certification.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Date date;
	private Time heure_debut;
	private Time heure_fin;
	private int duree;
	private Date date_reservation;
	private long ref_activite;
	private long ref_discipline;
	private long ref_utilisateur;
	
	public Reservation() { }

	public Reservation(long id, Date date, Time heure_debut, Time heure_fin, int duree, Date date_reservation,
			long ref_activite, long ref_discipline, long ref_utilisateur) {
		this.id = id;
		this.date = date;
		this.heure_debut = heure_debut;
		this.heure_fin = heure_fin;
		this.duree = duree;
		this.date_reservation = date_reservation;
		this.ref_activite = ref_activite;
		this.ref_discipline = ref_discipline;
		this.ref_utilisateur = ref_utilisateur;
	}

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

	public Time getHeure_debut() {
		return heure_debut;
	}

	public void setHeure_debut(Time heure_debut) {
		this.heure_debut = heure_debut;
	}

	public Time getHeure_fin() {
		return heure_fin;
	}

	public void setHeure_fin(Time heure_fin) {
		this.heure_fin = heure_fin;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Date getDate_reservation() {
		return date_reservation;
	}

	public void setDate_reservation(Date date_reservation) {
		this.date_reservation = date_reservation;
	}

	public long getRef_activite() {
		return ref_activite;
	}

	public void setRef_activite(long ref_activite) {
		this.ref_activite = ref_activite;
	}

	public long getRef_discipline() {
		return ref_discipline;
	}

	public void setRef_discipline(long ref_discipline) {
		this.ref_discipline = ref_discipline;
	}

	public long getRef_utilisateur() {
		return ref_utilisateur;
	}

	public void setRef_utilisateur(long ref_utilisateur) {
		this.ref_utilisateur = ref_utilisateur;
	}
}