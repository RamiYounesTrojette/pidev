package ManagedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Employee;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Employee employee;
}
