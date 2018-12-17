package co.simplon.certification.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Activity 
{
	// Création de la clé primaire activity_id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String activity;
	private float startTime;
	private float endTime;
	private Date dateActivity;
	
	@ManyToOne
	@JoinColumn(name="place_id")
	@JsonIgnore
	private Place place;
	
	public Activity() {}

	public Activity(long id, String activity, float startTime, float endTime, Date dateActivity, Place place) {
		super();
		this.id = id;
		this.activity = activity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dateActivity = dateActivity;
		this.place = place;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public float getStartTime() {
		return startTime;
	}

	public void setStartTime(float startTime) {
		this.startTime = startTime;
	}

	public float getEndTime() {
		return endTime;
	}

	public void setEndTime(float endTime) {
		this.endTime = endTime;
	}

	public Date getDateActivity() {
		return dateActivity;
	}

	public void setDateActivity(Date dateActivity) {
		this.dateActivity = dateActivity;
	}
}