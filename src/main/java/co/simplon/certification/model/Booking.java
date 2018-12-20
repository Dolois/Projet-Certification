package co.simplon.certification.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Booking.
 */
@Entity
public class Booking 
{
	/** Creer la cle primaire bookingid de booking */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	
	/** The date. */
	private Date date;
	
	/** The start time. */
	private Number startTime;
	
	/** The end time. */
	private Number endTime;
	
	/** The duration. */
	private int duration;
	
	/** The date booking. */
	private Date dateBooking;
	
	/**
	 * Instantiates a new booking.
	 */
	public Booking() { }

	/**
	 * Instantiates a new booking.
	 *
	 * @param bookingId the booking id
	 * @param date the date
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param duration the duration
	 * @param dateBooking the date booking
	 */
	public Booking(long bookingId, Date date, Number startTime, Number endTime, int duration, Date dateBooking) 
	{
		this.bookingId = bookingId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.dateBooking = dateBooking;
	}

	/**
	 * Gets the booking id.
	 *
	 * @return the booking id
	 */
	public long getBookingId() {
		return bookingId;
	}

	/**
	 * Sets the booking id.
	 *
	 * @param bookingId the new booking id
	 */
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the start time.
	 *
	 * @return the start time
	 */
	public Number getStartTime() {
		return startTime;
	}

	/**
	 * Sets the start time.
	 *
	 * @param startTime the new start time
	 */
	public void setStartTime(Number startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the end time.
	 *
	 * @return the end time
	 */
	public Number getEndTime() {
		return endTime;
	}

	/**
	 * Sets the end time.
	 *
	 * @param endTime the new end time
	 */
	public void setEndTime(Number endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Sets the duration.
	 *
	 * @param duration the new duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Gets the date booking.
	 *
	 * @return the date booking
	 */
	public Date getDateBooking() {
		return dateBooking;
	}

	/**
	 * Sets the date booking.
	 *
	 * @param dateBooking the new date booking
	 */
	public void setDateBooking(Date dateBooking) {
		this.dateBooking = dateBooking;
	}
}