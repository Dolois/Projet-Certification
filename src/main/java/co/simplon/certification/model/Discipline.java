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
public class Discipline 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String discipline;
	private String horaire;
	private long ref_activite;

	// Créer un constructor
	public Discipline() { }

	public Discipline(long id, String discipline, String horaire, long ref_activite) {
		this.id = id;
		this.discipline = discipline;
		this.horaire = horaire;
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

	public String getHoraire() {
		return horaire;
	}

	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	public long getRef_activite() {
		return ref_activite;
	}

	public void setRef_activite(long ref_activite) {
		this.ref_activite = ref_activite;
	}
}