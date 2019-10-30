package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Task  implements Serializable {

private static final long serialVersionUID = 1L;
 
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String title ;
private String description ;
private Date startDate ;
private Date endDate ;

public Task(int id, String title, String description, Date startDate, Date endDate) {
super();
this.id = id;
this.title = title;
this.description = description;
this.startDate = startDate;
this.endDate = endDate;
}



public Task(String title, String description) {
super();
this.title = title;
this.description = description;
}



public Task() {
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

public Date getStartDate() {
return startDate;
}

public void setStartDate(Date startDate) {
this.startDate = startDate;
}

public Date getEndDate() {
return endDate;
}

public void setEndDate(Date endDate) {
this.endDate = endDate;
}

@ManyToOne(cascade=CascadeType.ALL)
private Project project;

@ManyToOne(cascade=CascadeType.ALL)
private Employee employee;

public Project getProject() {
return project;
}
public void setProject(Project project) {
this.project = project;
}

public Employee getEmployee() {
return employee;
}
public void setEmployee(Employee employee) {
this.employee= employee;
}



}