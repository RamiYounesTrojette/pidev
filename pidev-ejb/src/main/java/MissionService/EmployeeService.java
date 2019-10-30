package MissionService;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Employee;
import Entities.Team;



@Stateless
@LocalBean
public class EmployeeService {

	@PersistenceContext
	EntityManager em;
	
	public int addEmploye(Employee employee) {
		em.persist(employee);
		return employee.getId();
	}
	

	public void deleteEmployeById(int employeId) {
		Employee employe = em.find(Employee.class, employeId);
		
		//Desaffecter l'employe de toutes les equipes
		for(Team team : employe.getTeams()){
			team.getEmployees().remove(employe);
		}
		
		em.remove(employe);
	}
	
	public void updateEmploye(Employee employe) { 
		Employee emp = em.find(Employee.class, employe.getId()); 
		emp.setFirstname(employe.getFirstname()); 
		emp.setFirstname(employe.getLastname()); 
		emp.setEmail(employe.getEmail()); 
		emp.setPassword(employe.getPassword()); 
		emp.setIsActif(employe.getIsActif()); 
		emp.setRole(employe.getRole()); 
		emp.setBirthday(employe.getBirthday()); 
		em.persist(emp);
	}
	
	public void updateEmployeeByEmployee(Employee employee) { 
		Employee emp = em.find(Employee.class, employee.getId()); 
		emp.setPhoto(employee.getPhoto());
		emp.setPhone(employee.getPhone());
		emp.setPassword(employee.getPassword());

	}
	
	public Employee getEmployeeByEmailAndPassword(String email, String password) {
		TypedQuery<Employee> query = 
		em.createQuery("select e from Employee e WHERE e.email=:email and e.password=:password ", Employee.class); 
		query.setParameter("email", email); 
		query.setParameter("password", password); 
		Employee employee = null; 
		try {
			employee = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return employee;
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> emp = em.createQuery("Select e from Employee e", Employee.class).getResultList();
		return emp;
	}
	
}
