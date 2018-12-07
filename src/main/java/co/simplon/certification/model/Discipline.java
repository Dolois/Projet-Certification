package co.simplon.certification.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Discipline 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long disciplineId;
	private String discipline;
	private Time startTime;
	private Time endTime;
	private Date date_discipline;
	
    @ManyToOne
    private Activity activity;

	// Créer un constructor
	public Discipline() { }

	public Discipline(long disciplineId, String discipline, Time startTime, Time endTime, Date date_discipline,
			Activity activity) 
	{
		this.disciplineId = disciplineId;
		this.discipline = discipline;
		this.startTime = startTime;
		this.endTime = endTime;
		this.date_discipline = date_discipline;
		this.activity = activity;
	}

	public long getDisciplineId() {
		return disciplineId;
	}

	public void setDisciplineId(long disciplineId) {
		this.disciplineId = disciplineId;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Date getDate_discipline() {
		return date_discipline;
	}

	public void setDate_discipline(Date date_discipline) {
		this.date_discipline = date_discipline;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}