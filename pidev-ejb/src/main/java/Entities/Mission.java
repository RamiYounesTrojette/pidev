package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Mission  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private Date dateD;
	private Date DateF;
	private String location;
	@Enumerated(EnumType.STRING)
	private Type type;
	private int valide;
	
	
	@OneToOne
	private Bill bill;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Project project;
	
	@ManyToMany(mappedBy="missions",cascade=CascadeType.ALL)
	private Set<Employee> employes;
	
	@ManyToMany(mappedBy="missions",cascade=CascadeType.ALL)
	private Set<Compentency> skill;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="mission")
	private Set<MissionRequest> missionsRequests;

	public Mission() {
		super();
	}

	public Mission(int id, String title, Date dateD, Date dateF, String location, Type type, int valide) {
		super();
		this.id = id;
		this.title = title;
		this.dateD = dateD;
		DateF = dateF;
		this.location = location;
		this.type = type;
		this.valide = valide;
	}

	public Mission(String title, Date dateD, Date dateF, String location, Type type, int valide) {
		super();
		this.title = title;
		this.dateD = dateD;
		DateF = dateF;
		this.location = location;
		this.type = type;
		this.valide = valide;
	}

	public Mission(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDateD() {
		return dateD;
	}

	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}

	public Date getDateF() {
		return DateF;
	}

	public void setDateF(Date dateF) {
		DateF = dateF;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getValide() {
		return valide;
	}

	public void setValide(int valide) {
		this.valide = valide;
	}

	@Override
	public String toString() {
		return "Mission [id=" + id + ", title=" + title + ", dateD=" + dateD + ", DateF=" + DateF + ", location="
				+ location + ", type=" + type + ", valide=" + valide + "]";
	}
	
	
	
	
	
}
