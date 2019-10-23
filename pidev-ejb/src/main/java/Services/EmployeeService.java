package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Employee;

@Stateless
@LocalBean
public class EmployeeService {

	@PersistenceContext
	EntityManager em;
	
	public int addEmploye(Employee employee) {
		em.persist(employee);
		return employee.getId();
	}
	
	public void updateEmployee(Employee employee) { 
		Employee emp = em.find(Employee.class, employee.getId()); 
		emp.setPhoto(employee.getPhoto());
		emp.setPhone(employee.getPhone());

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
