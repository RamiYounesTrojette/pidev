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

@ManagedBean(name = "jobFamilyBean")
@SessionScoped
public class JobFamilyBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private JobFamily jobFamily;

	@EJB
	GenericService _service;


	public String selectJob(Job job) {
		//selectedJob = job;
		return "/pages/competencies/JobDetails?faces-redirect=true";
	}


	public JobFamily getJobFamily() {
		return jobFamily;
	}


	public void setJobFamily(JobFamily JobFamily) {
		this.jobFamily = JobFamily;
	}

}
