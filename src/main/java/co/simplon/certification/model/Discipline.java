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
		
	private String structure;

	// Créer un constructor
	public Discipline() { }
	
	//Créer un constructor
	public Discipline(long id, String structure) 
	{
		this.id = id;
		this.structure = structure;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}
}