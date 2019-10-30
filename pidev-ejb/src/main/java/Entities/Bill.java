package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Bill  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String matricule;
	private String description;
	private String image; 
	private Date date;
	
	
	@OneToOne
	private Mission mission;
	//test


	public Bill() {
		super();
	}
	
	

	public Bill(int id) {
		
		this.id = id;
	}



	public Bill(String matricule, String description, String image, Date date) {
		super();
		this.matricule = matricule;
		this.description = description;
		this.image = image;
		this.date = date;
	}


	public Bill(int id, String matricule, String description, String image, Date date) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.description = description;
		this.image = image;
		this.date = date;
	}




	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public Mission getMission() {
		return mission;
	}


	public void setMission(Mission mission) {
		this.mission = mission;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Bill [id=" + id + ", matricule=" + matricule + ", description=" + description + ", image=" + image
				+ ", date=" + date + "]";
	}
	
	
	
}