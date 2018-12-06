package co.simplon.certification.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User 
{
	// Creer la clef primaire
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long UserId;
	private String email;
	private String password;
	
	@OneToOne
	private Discipline DisciplineId;
	
	public User() { }



	public User(long userId, String email, String password, Discipline disciplineId) 
	{
		UserId = userId;
		this.email = email;
		this.password = password;
		DisciplineId = disciplineId;
	}

	public long getUserId() {
		return UserId;
	}

	public void setUserId(long userId) {
		UserId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Discipline getDisciplineId() {
		return DisciplineId;
	}

	public void setDisciplineId(Discipline disciplineId) {
		DisciplineId = disciplineId;
	}
}