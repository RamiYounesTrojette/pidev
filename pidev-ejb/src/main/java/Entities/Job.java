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
import javax.persistence.OneToMany;

@Entity
public class Job  implements Serializable {
	
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int level;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private JobFamily jobfamily;
	
	@ManyToMany(mappedBy = "jobs", cascade = CascadeType.ALL)
	private List<Competency> competencies;
	
	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
	private List<Employee> employees;
}