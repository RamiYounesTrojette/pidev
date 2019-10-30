package TimesheetInterface;

import java.util.List;

import javax.ejb.Remote;

import Entities.Employee;
import Entities.Project;
import Entities.Task;


@Remote
public interface IProjectServiceRemote {
//project
public int ajouterProject(Project project);
public void deleteProjectById(int projectId) ;
public List<Project> getAllProjects();
void updateProject(Project project);

//task
//public int ajouterTask(Task task, Project p);
public int ajouterTask(Task task, Project p, Employee e);
public void deleteTaskById(int taskId) ;
public void affecterTaskAProject(int taskId, int projectId);
public void affecterTaskAEmployee(int taskId, int employeeId);
public List<Task> getAllTasks();
void updateTask(Task task);


}
