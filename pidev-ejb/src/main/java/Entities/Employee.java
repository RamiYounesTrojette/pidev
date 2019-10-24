package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Employee  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Job job;
	
	@ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)
	private List<Competency> competencies;

	public int getId() {
		return id;
	}

	public Job getJob() {
		return job;
	}

	public List<Competency> getCompetencies() {
		return competencies;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public void setCompetencies(List<Competency> competencies) {
		this.competencies = competencies;
	}
}
