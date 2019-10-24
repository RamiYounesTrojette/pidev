package ManagedBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.JobFamily;
import Entities.Job;
import Entities.Competency;

@ManagedBean(name = "competenciesBean")
@SessionScoped
public class CompetenciesBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<JobFamily> jobFamilies;
	private JobFamily selectedJobFamily;
	private Job selectedJob;
	
	public boolean LoadJobFamilies() {
		Competency c1 = new Competency();
		return true;
	}
	
	public List<JobFamily> getJobFamilies() {
		return jobFamilies;
	}
	public JobFamily getSelectedJobFamily() {
		return selectedJobFamily;
	}
	public Job getSelectedJob() {
		return selectedJob;
	}
	public void setJobFamilies(List<JobFamily> jobFamilies) {
		this.jobFamilies = jobFamilies;
	}
	public void setSelectedJobFamily(JobFamily selectedJobFamily) {
		this.selectedJobFamily = selectedJobFamily;
	}
	public void setSelectedJob(Job selectedJob) {
		this.selectedJob = selectedJob;
	}
}
