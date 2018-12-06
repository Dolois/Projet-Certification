package co.simplon.certification.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ActivityId;
	
	private String etablissement;
	private String nom;
	private String adresse;
	private String ville;
	private String codepostal;
	private String telephone;
	private String jour_1;
	private String jour_2;
	private String jour_3;
	private String jour_4;
	private String jour_5;
	private String jour_6;
	private String jour_7;
	private String image;
	private double longitude;
	private double latitude;
	private Date date_activite;
	
	public Activity() { }

	public Activity(long activityId, String etablissement, String nom, String adresse, String ville, String codepostal,
			String telephone, String jour_1, String jour_2, String jour_3, String jour_4, String jour_5, String jour_6,
			String jour_7, String image, double longitude, double latitude, Date date_activite) 
	{
		ActivityId = activityId;
		this.etablissement = etablissement;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.codepostal = codepostal;
		this.telephone = telephone;
		this.jour_1 = jour_1;
		this.jour_2 = jour_2;
		this.jour_3 = jour_3;
		this.jour_4 = jour_4;
		this.jour_5 = jour_5;
		this.jour_6 = jour_6;
		this.jour_7 = jour_7;
		this.image = image;
		this.longitude = longitude;
		this.latitude = latitude;
		this.date_activite = date_activite;
	}

	public long getActivityId() {
		return ActivityId;
	}

	public void setActivityId(long activityId) {
		ActivityId = activityId;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getJour_1() {
		return jour_1;
	}

	public void setJour_1(String jour_1) {
		this.jour_1 = jour_1;
	}

	public String getJour_2() {
		return jour_2;
	}

	public void setJour_2(String jour_2) {
		this.jour_2 = jour_2;
	}

	public String getJour_3() {
		return jour_3;
	}

	public void setJour_3(String jour_3) {
		this.jour_3 = jour_3;
	}

	public String getJour_4() {
		return jour_4;
	}

	public void setJour_4(String jour_4) {
		this.jour_4 = jour_4;
	}

	public String getJour_5() {
		return jour_5;
	}

	public void setJour_5(String jour_5) {
		this.jour_5 = jour_5;
	}

	public String getJour_6() {
		return jour_6;
	}

	public void setJour_6(String jour_6) {
		this.jour_6 = jour_6;
	}

	public String getJour_7() {
		return jour_7;
	}

	public void setJour_7(String jour_7) {
		this.jour_7 = jour_7;
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

	public Date getDate_activite() {
		return date_activite;
	}

	public void setDate_activite(Date date_activite) {
		this.date_activite = date_activite;
	}
}