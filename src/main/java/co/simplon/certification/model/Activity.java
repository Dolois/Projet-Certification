package co.simplon.certification.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Activity 
{
	// Création de la clé primaire activity_id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long activityId;
	
	private String activity;
	private float startTime;
	private float endTime;
	private Date dateActivity;
	
	@OneToMany (mappedBy = "activity")
	private List<Place> places;
	
	public Activity() {}

	public Activity(long activityId, String activity, float startTime, float endTime, Date dateActivity,
			List<Place> places) 
	{
		this.activityId = activityId;
		this.activity = activity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dateActivity = dateActivity;
		this.places = places;
	}

	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(long activityId) {
		this.activityId = activityId;
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

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}
}