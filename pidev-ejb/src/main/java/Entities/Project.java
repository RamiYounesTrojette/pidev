package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Project  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title ;
	private String description ;

	private String startDate ;

	private String endDate ;
	
	@OneToMany(mappedBy="project")
	private Set<Mission> missions;
	
	@OneToMany(cascade=CascadeType.MERGE,mappedBy="project")
	private Set<Task> tasks;

	@ManyToMany(cascade=CascadeType.MERGE,mappedBy="project")
	private Set<Employee> employees;

	public Set<Task> getTasks() {
	return tasks;
	}
	public void setTasks(Set<Task> tasks) {
	this.tasks = tasks;
	}

	public Set<Employee> getEmployees() {
	return employees;
	}
	public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
	}


	public Project(int id) {

		this.id = id;
	}


	
	public Project() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public Project(int id, String title, String description, String startDate, String endDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		}

		public Project( String title, String description, String startDate, String endDate) {
		
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		}






		public Project(String description, String startDate, String endDate) {
		
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		}


		public Project(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		}


	

	public Set<Mission> getMissions() {
		return missions;
	}

	public void setMissions(Set<Mission> missions) {
		this.missions = missions;
	}
	@Override
	public String toString() {
		return title;
	}

	
	
	
}
