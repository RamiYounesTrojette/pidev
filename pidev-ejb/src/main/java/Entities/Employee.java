package Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Employee  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String prenom;
	private String nom;
	private String email;
	private Boolean isActif;
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Mission> missions;
	@OneToOne
	private MissionRequest missionRequest;
	public Employee() {
		
	}
	public Employee(String prenom, String nom, String email, Boolean isActif, String password, Role role) {
		super();
		
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.isActif = isActif;
		this.password = password;
		this.role = role;
		
	}
	
	public Employee(int id, String prenom, String nom, String email, String
			password, Boolean isActif, Role role) {
			this.id = id;
			this.prenom = prenom;
			this.nom = nom;
			this.email = email;
			this.password = password;
			this.isActif = isActif;
			this.role = role;
			}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsActif() {
		return isActif;
	}
	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Set<Mission> getMissions() {
		return missions;
	}
	public void setMissions(List<Mission> missions2) {
		this.missions = (Set<Mission>) missions2;
	}
	public MissionRequest getMissionRequest() {
		return missionRequest;
	}
	public void setMissionRequest(MissionRequest missionRequest) {
		this.missionRequest = missionRequest;
	}
	
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="employee")
	private Set<Task> task;

	@ManyToMany(cascade=CascadeType.MERGE)
	private Set<Project> project;

	public Set<Task> getTask() {
	return task;
	}
	public void setTask(Set<Task> task) {
	this.task = task;
	}

	public Set<Project> getProject() {
	return project;
	}
	public void setProject(Set<Project> project) {
	this.project = project;
	}
	@Override
	public String toString() {
		return nom;
	}
	
	
	
}
