package managedbeans;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Entities.TypeEvaluationSheet;


@ManagedBean(name = "data") 
@ApplicationScoped 
public class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	public TypeEvaluationSheet[] getType() 
	{ 
		return TypeEvaluationSheet.values();
	}

}