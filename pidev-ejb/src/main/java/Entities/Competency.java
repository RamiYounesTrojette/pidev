package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Competency  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int level;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Job> jobs;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Employee> employees;

	public Competency() {
	}

	public Competency(int id, String name, String description, int level, List<Job> jobs, List<Employee> employees) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.level = level;
		this.jobs = jobs;
		this.employees = employees;
	}

	public Competency(String name, String description, int level, List<Job> jobs, List<Employee> employees) {
		this.name = name;
		this.description = description;
		this.level = level;
		this.jobs = jobs;
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getLevel() {
		return level;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
