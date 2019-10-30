package EmployeeInterface;

import javax.ejb.Remote;

import Entities.Employee;

@Remote
public interface IEmployeeServiceRemote {
	public Employee getEmployeeByName(String name)  ;
	

}
