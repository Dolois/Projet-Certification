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

// TODO: Auto-generated Javadoc
/**
 * The Class Activity.
 */
@Entity
public class Activity 
{
	/** Creer la cle primaire id de l'entite Activity */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/** The activity. */
	private String activity;
	
	/** The start time. */
	private float startTime;
	
	/** The end time. */
	private float endTime;
	
	/** The date activity. */
	private Date dateActivity;
	
	/** The place. */
	@ManyToOne
	@JoinColumn(name="place_id")
	@JsonIgnore
	private Place place;
	
	/**
	 * Instantiates a new activity.
	 */
	public Activity() {}

	/**
	 * Instantiates a new activity.
	 *
	 * @param id the id
	 * @param activity the activity
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param dateActivity the date activity
	 * @param place the place
	 */
	public Activity(long id, String activity, float startTime, float endTime, Date dateActivity, Place place) {
		super();
		this.id = id;
		this.activity = activity;
		this.startTime = startTime;
		this.endTime = endTime;
		this.dateActivity = dateActivity;
		this.place = place;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the place.
	 *
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * Sets the place.
	 *
	 * @param place the new place
	 */
	public void setPlace(Place place) {
		this.place = place;
	}

	/**
	 * Gets the activity.
	 *
	 * @return the activity
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * Sets the activity.
	 *
	 * @param activity the new activity
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public float getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time.
	 *
	 * @param startTime the new start time
	 */
	public void setStartTime(float startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public float getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime the new end time
	 */
	public void setEndTime(float endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the date activity.
	 *
	 * @return the date activity
	 */
	public Date getDateActivity() {
		return dateActivity;
	}

	/**
	 * Sets the date activity.
	 *
	 * @param dateActivity the new date activity
	 */
	public void setDateActivity(Date dateActivity) {
		this.dateActivity = dateActivity;
	}
}