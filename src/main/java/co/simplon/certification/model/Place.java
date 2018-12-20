package co.simplon.certification.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Place.
 */
@Entity
public class Place
{
	// Creer la cle primaire id de PLace */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/** The place. */
	private String place;
	
	/** The name. */
	private String name;
	
	/** The address. */
	private String address;
	
	/** The city. */
	private String city;
	
	/** The zip code. */
	private String zipCode;
	
	/** The phone. */
	private String phone;
	
	/** The monday. */
	private String monday;
	
	/** The tuesday. */
	private String tuesday;
	
	/** The wednesday. */
	private String wednesday;
	
	/** The thursday. */
	private String thursday;
	
	/** The friday. */
	private String friday;
	
	/** The saturday. */
	private String saturday;
	
	/** The sunday. */
	private String sunday;
	
	/** The image. */
	private String image;
	
	/** The longitude. */
	private double longitude;
	
	/** The latitude. */
	private double latitude;
	
	/** The date place. */
	private Date datePlace;
	
	/** @One = entite Place
	 * To
	 * Many = liste de classe Activity du nouvel attribut activities
	 */
	
	/** The activities. */
	@OneToMany(mappedBy = "place")
	private List<Activity> activities;

	/**
	 * Instantiates a new place.
	 */
	
	/** Creation d'un constructeur d'objet place */
	public Place() {}

	/**
	 * Instantiates a new place.
	 *
	 * @param id the id
	 * @param place the place
	 * @param name the name
	 * @param address the address
	 * @param city the city
	 * @param zipCode the zip code
	 * @param phone the phone
	 * @param monday the monday
	 * @param tuesday the tuesday
	 * @param wednesday the wednesday
	 * @param thursday the thursday
	 * @param friday the friday
	 * @param saturday the saturday
	 * @param sunday the sunday
	 * @param image the image
	 * @param longitude the longitude
	 * @param latitude the latitude
	 * @param datePlace the date place
	 * @param activities the activities
	 */
	public Place(long id, String place, String name, String address, String city, String zipCode, String phone,
			String monday, String tuesday, String wednesday, String thursday, String friday, String saturday,
			String sunday, String image, double longitude, double latitude, Date datePlace, List<Activity> activities) 
	{
		this.id = id;
		this.place = place;
		this.name = name;
		this.address = address;
		this.city = city;
		this.zipCode = zipCode;
		this.phone = phone;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wednesday = wednesday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
		this.image = image;
		this.longitude = longitude;
		this.latitude = latitude;
		this.datePlace = datePlace;
		this.activities = activities;
	}



	/**
	 * Gets the place.
	 *
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * Sets the place.
	 *
	 * @param place the new place
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the zip code.
	 *
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * Sets the zip code.
	 *
	 * @param zipCode the new zip code
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the monday.
	 *
	 * @return the monday
	 */
	public String getMonday() {
		return monday;
	}

	/**
	 * Sets the monday.
	 *
	 * @param monday the new monday
	 */
	public void setMonday(String monday) {
		this.monday = monday;
	}

	/**
	 * Gets the tuesday.
	 *
	 * @return the tuesday
	 */
	public String getTuesday() {
		return tuesday;
	}

	/**
	 * Sets the tuesday.
	 *
	 * @param tuesday the new tuesday
	 */
	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	/**
	 * Gets the wednesday.
	 *
	 * @return the wednesday
	 */
	public String getWednesday() {
		return wednesday;
	}

	/**
	 * Sets the wednesday.
	 *
	 * @param wednesday the new wednesday
	 */
	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	/**
	 * Gets the thursday.
	 *
	 * @return the thursday
	 */
	public String getThursday() {
		return thursday;
	}

	/**
	 * Sets the thursday.
	 *
	 * @param thursday the new thursday
	 */
	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	/**
	 * Gets the friday.
	 *
	 * @return the friday
	 */
	public String getFriday() {
		return friday;
	}

	/**
	 * Sets the friday.
	 *
	 * @param friday the new friday
	 */
	public void setFriday(String friday) {
		this.friday = friday;
	}

	/**
	 * Gets the saturday.
	 *
	 * @return the saturday
	 */
	public String getSaturday() {
		return saturday;
	}

	/**
	 * Sets the saturday.
	 *
	 * @param saturday the new saturday
	 */
	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	/**
	 * Gets the sunday.
	 *
	 * @return the sunday
	 */
	public String getSunday() {
		return sunday;
	}

	/**
	 * Sets the sunday.
	 *
	 * @param sunday the new sunday
	 */
	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Gets the date place.
	 *
	 * @return the date place
	 */
	public Date getDatePlace() {
		return datePlace;
	}

	/**
	 * Sets the date place.
	 *
	 * @param datePlace the new date place
	 */
	public void setDatePlace(Date datePlace) {
		this.datePlace = datePlace;
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
	 * Gets the activities.
	 *
	 * @return the activities
	 */
	public List<Activity> getActivities() {
		return activities;
	}

	/**
	 * Sets the activities.
	 *
	 * @param activities the new activities
	 */
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	
}