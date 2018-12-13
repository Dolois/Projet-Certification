package co.simplon.certification.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	
	private Date date;
	private Number startTime;
	private Number endTime;
	private int duration;
	private Date dateBooking;
	
	public Booking() { }

	public Booking(long bookingId, Date date, Number startTime, Number endTime, int duration, Date dateBooking) 
	{
		this.bookingId = bookingId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.dateBooking = dateBooking;
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

	public Number getStartTime() {
		return startTime;
	}

	public void setStartTime(Number startTime) {
		this.startTime = startTime;
	}

	public Number getEndTime() {
		return endTime;
	}

	public void setEndTime(Number endTime) {
		this.endTime = endTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getDateBooking() {
		return dateBooking;
	}

	public void setDateBooking(Date dateBooking) {
		this.dateBooking = dateBooking;
	}
}