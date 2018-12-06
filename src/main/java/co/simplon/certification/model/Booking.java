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
	private long BookingId;
	private Date date;
	private Time heure_debut;
	private Time heure_fin;
	private int duree;
	private Date date_reservation;

    @ManyToOne
    private Activity ActivityId;    

    @ManyToOne
    private User UserId;
    
    @OneToOne
    private Discipline DisciplineId;
	
	public Booking() { }

	public Booking(long bookingId, Date date, Time heure_debut, Time heure_fin, int duree, Date date_reservation,
			Activity activityId, User userId, Discipline disciplineId) 
	{
		BookingId = bookingId;
		this.date = date;
		this.heure_debut = heure_debut;
		this.heure_fin = heure_fin;
		this.duree = duree;
		this.date_reservation = date_reservation;
		ActivityId = activityId;
		UserId = userId;
		DisciplineId = disciplineId;
	}

	public long getBookingId() {
		return BookingId;
	}

	public void setBookingId(long bookingId) {
		BookingId = bookingId;
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

	public Activity getActivityId() {
		return ActivityId;
	}

	public void setActivityId(Activity activityId) {
		ActivityId = activityId;
	}

	public User getUserId() {
		return UserId;
	}

	public void setUserId(User userId) {
		UserId = userId;
	}

	public Discipline getDisciplineId() {
		return DisciplineId;
	}

	public void setDisciplineId(Discipline disciplineId) {
		DisciplineId = disciplineId;
	}
}