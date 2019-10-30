package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import Entities.JobFamily;
import Services.GenericService;
import Entities.Job;
import Entities.Competency;
import Entities.Employee;

@ManagedBean(name = "jobBean")
@SessionScoped
public class JobBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Job job;

	@EJB
	GenericService _service;


	public String selectCompetency(Competency competency) {
		//selectedJob = job;
		return "/pages/competencies/JobDetails?faces-redirect=true";
	}


	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}
}
