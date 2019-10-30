package TimesheetService;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Employee;
import Entities.Project;
import Entities.Task;
import TimesheetInterface.IProjectServiceRemote;




@Stateless
@LocalBean

public class ProjectServImpl implements IProjectServiceRemote {

@PersistenceContext
EntityManager em;

@Override
public int ajouterProject(Project project) {

em.persist(project);
return project.getId();
}

@Override
public void deleteProjectById(int projectId) {
Project  project =em.find(Project.class, projectId);
em.remove(project);
}

@Override
public int ajouterTask(Task task, Project p, Employee e)
{

Project emp = em.find(Project.class, p.getId());
Employee empl = em.find(Employee.class, e.getId());
em.persist(task);
task.setProject(emp);
task.setEmployee(empl);
return task.getId();
}

@Override
public void deleteTaskById(int taskId) {
Task  task =em.find(Task.class, taskId);
em.remove(task);
}

@Override
public void affecterTaskAProject(int taskId, int projectId) {
Task task=em.find(Task.class, taskId);
Project pr=em.find(Project.class, projectId);
pr.getTasks().add(task);
}

@Override
public void affecterTaskAEmployee(int taskId, int employeeId) {
Task task=em.find(Task.class, taskId);
Employee emp=em.find(Employee.class, employeeId);
emp.getTask().add(task);
}

@Override
public List<Project> getAllProjects() {
List<Project> p = em.createQuery("Select e from Project e", Project.class).getResultList();
return p;
}

@Override
public List<Task> getAllTasks() {
List<Task> t = em.createQuery("Select e from Task tt", Task.class).getResultList();
return t;
}

@Override
public void updateProject(Project project) {
Project p = em.find(Project.class, project.getId());
p.setTitle(project.getTitle());
p.setDescription(project.getDescription());
p.setStartDate(project.getStartDate());
p.setEndDate(project.getEndDate());

}

@Override
public void updateTask(Task task) {
Task t = em.find(Task.class, task.getId());
t.setTitle(task.getTitle());
t.setDescription(task.getDescription());
t.setStartDate(task.getStartDate());
t.setEndDate(task.getEndDate());

}


}