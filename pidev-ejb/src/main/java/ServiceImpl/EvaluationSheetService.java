package ServiceImpl;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.EvaluationSheet;
import ServiceRemote.EvaluationSheetInterf;






@Stateless
@LocalBean
public class EvaluationSheetService implements EvaluationSheetInterf {

	@PersistenceContext
	EntityManager em;


	public int ajouterEvaluationSheet(EvaluationSheet evaluationsheet) {
		em.persist(evaluationsheet);
		return evaluationsheet.getId();
	}
	@Override
	public void updateEval(EvaluationSheet evaluationsheet) { 
		EvaluationSheet emp = em.find(EvaluationSheet.class, evaluationsheet.getId()); 
		emp.setScore(evaluationsheet.getScore()); 
		emp.setTypeevaluation(evaluationsheet.getTypeevaluation());
	}


	
	public void removeEval(int id) {
		System.out.println("In removeEmp : ");
		em.remove(em.find(EvaluationSheet.class, id));
		System.out.println("Out of removeEmp : ");	

	}
	
	public List <EvaluationSheet> getAllEval() { List <EvaluationSheet> emp = em.createQuery("Select e from EvaluationSheet e",
			EvaluationSheet.class).getResultList(); return emp;}
	}
