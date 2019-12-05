package Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import Interfaces.IBaseEntity;

@Entity
public class Employee  implements Serializable, IBaseEntity {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Job job;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "employees", cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Competency> competencies;

	@Override
	public int getId() {
		return id;
	}

	public Job getJob() {
		return job;
	}

	public Set<Competency> getCompetencies() {
		return competencies;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setCompetencies(Set<Competency> competencies) {
		this.competencies = competencies;
	}
}
