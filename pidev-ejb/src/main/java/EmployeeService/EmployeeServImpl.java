package EmployeeService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Employee;
import Entities.Project;
import EmployeeInterface.IEmployeeServiceRemote;


@Stateless
@LocalBean
public class EmployeeServImpl implements IEmployeeServiceRemote {

@PersistenceContext
EntityManager em;


@Override
public Employee getEmployeeByName(String name) {
	TypedQuery<Employee> query=em.createQuery("SELECT e FROM Employee e WHERE e.nom=:name",Employee.class);
	
	query.setParameter("name",name);
	Employee emp = null ;
	try {
		emp=query.getSingleResult();
} 
	catch (Exception e)
	{System.out.println("Erreur :+e") ;}
	return emp ;
}




}