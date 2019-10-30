package Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import Interfaces.IBaseEntity;

@Entity
public class JobFamily  implements Serializable, IBaseEntity {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="jobfamily",  cascade = CascadeType.ALL)
	private Set<Job> jobs;

	public JobFamily() {
	}

	public JobFamily(int id, String name, String description, Set<Job> jobs) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.jobs = jobs;
	}

	public JobFamily(String name, String description, Set<Job> jobs) {
		this.name = name;
		this.description = description;
		this.jobs = jobs;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Set<Job> getJobs() {
		return jobs;
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

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
}
