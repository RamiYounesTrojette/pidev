package tn.esprit.mission.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Entities.Type;

@ManagedBean(name="data")
@ApplicationScoped
public class Data implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Type[] getTypes() { return Type.values(); }
}
