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

@Entity
public class Place
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String place;
	private String name;
	private String address;
	private String city;
	private String zipCode;
	private String phone;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String saturday;
	private String sunday;
	private String image;
	private double longitude;
	private double latitude;
	private Date datePlace;
	
	// @One = entité Place
	// To
	// Many = liste de classe Activity du nouvel attribut activities
	
	@OneToMany(mappedBy = "place")
	private List<Activity> activities;

	// Création d'un constructeur d'objet place
	public Place() {}

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



	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Date getDatePlace() {
		return datePlace;
	}

	public void setDatePlace(Date datePlace) {
		this.datePlace = datePlace;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	
}