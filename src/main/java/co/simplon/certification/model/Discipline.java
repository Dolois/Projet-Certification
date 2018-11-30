package co.simplon.certification.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Discipline 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String discipline;
	private String horaire_debut;
	private String horaire_fin;
	private Date date_discipline;
	private long ref_activite;

	// Créer un constructor
	public Discipline() { }

	public Discipline(long id, String discipline, String horaire_debut, String horaire_fin, Date date_discipline,
			long ref_activite) 
	{
		this.id = id;
		this.discipline = discipline;
		this.horaire_debut = horaire_debut;
		this.horaire_fin = horaire_fin;
		this.date_discipline = date_discipline;
		this.ref_activite = ref_activite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public String getHoraire_debut() {
		return horaire_debut;
	}

	public void setHoraire_debut(String horaire_debut) {
		this.horaire_debut = horaire_debut;
	}

	public String getHoraire_fin() {
		return horaire_fin;
	}

	public void setHoraire_fin(String horaire_fin) {
		this.horaire_fin = horaire_fin;
	}

	public Date getDate_discipline() {
		return date_discipline;
	}

	public void setDate_discipline(Date date_discipline) {
		this.date_discipline = date_discipline;
	}

	public long getRef_activite() {
		return ref_activite;
	}

	public void setRef_activite(long ref_activite) {
		this.ref_activite = ref_activite;
	}
}