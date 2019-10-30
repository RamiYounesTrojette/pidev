package tn.esprit.timesheet.managedbeans;



import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Entities.Project;
import TimesheetService.ProjectServImpl;



@ManagedBean(name = "projectBean")
@SessionScoped
public class ProjectBean implements Serializable {

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String title ;
private String description ;
private String startDate ;
private String endDate ;
private List<Project> projects;

@EJB
private ProjectServImpl projectService;





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

public ProjectServImpl getProjectService() {
return projectService;
}

public void setProjectService(ProjectServImpl projectService) {
this.projectService = projectService;
}

public List<Project> getProjects() {
projects = projectService.getAllProjects();
return projects;
}

public void setProjects(List<Project> projects) {
this.projects = projects;
}

public void addProject() {
projectService.ajouterProject(new Project(title,description,endDate,startDate));
}

public void removeProject(int projectId) {
projectService.deleteProjectById(projectId);
}

private Integer projectIdToBeUpdated;

public void displayProject(Project pl) { this.setTitle(pl.getTitle()); this.setDescription(pl.getDescription()); this.setStartDate(pl.getStartDate()); this.setEndDate(pl.getEndDate()); this.setProjectIdToBeUpdated(pl.getId());


}

public Integer getProjectIdToBeUpdated() {
return projectIdToBeUpdated;
}

public void setProjectIdToBeUpdated(Integer projectIdToBeUpdated) {
this.projectIdToBeUpdated = projectIdToBeUpdated;
}

public void updateProject() {

projectService.updateProject(new Project(projectIdToBeUpdated, title,description,startDate,endDate )); }


String navigateTo = "null";

public String gototask()
{
return navigateTo = "/pages/admin/task?faces-redirect=true";
}
}


