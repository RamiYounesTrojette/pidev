package managedbeans;



import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Employee;
import ServiceImpl.employeeService;



@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login; 
	
	
	public employeeService getEmployeService() {
		return employeService;
	}
	public void setEmployeService(employeeService employeService) {
		this.employeService = employeService;
	}
	private String password;
	private Employee employe;
	private Boolean loggedIn;
	@EJB
	employeeService employeService;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Employee getEmploye() {
		return employe;
	}
	public void setEmploye(Employee employe) {
		this.employe = employe;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public String doLogin() {
		String navigateTo = "null";
		employe = employeService.getEmployeByEmailAndPassword(login, password);
		if (employe != null ) {
			navigateTo = "/test?faces-redirect=true"; loggedIn = true; }
		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));}
		return navigateTo; }
	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true"; }}