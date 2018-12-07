package co.simplon.certification.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Booking 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	private Date date;
	private Time startTime;
	private Time endTime;
	private int duration;
	private Date date_booking;

    @ManyToOne
    private Activity activity;    
    
    @OneToOne
    private Discipline discipline;
    
    @ManyToOne
    private User userId;
	
	public Booking() { }

	public Booking(long bookingId, Date date, Time startTime, Time endTime, int duration, Date date_booking,
			Activity activity, Discipline discipline, User userId) 
	{
		this.bookingId = bookingId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.date_booking = date_booking;
		this.activity = activity;
		this.discipline = discipline;
		this.userId = userId;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getDate_booking() {
		return date_booking;
	}

	public void setDate_booking(Date date_booking) {
		this.date_booking = date_booking;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
}