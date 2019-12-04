
package ServiceImpl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Criteria;
import Entities.EvaluationSheet;
import ServiceRemote.CriteriaRemote;

@Stateless
@LocalBean
public class CriteriaService implements CriteriaRemote {

	@PersistenceContext
	EntityManager em;


	public  int ajouterCriteria(Criteria criteria) {
		em.persist(criteria);
		return criteria.getId();
			
	}
	public  int ajouterev(EvaluationSheet ev) {
		em.persist(ev);
		return ev.getId();
			
	}
	public List <Criteria> getAllCriterien() { List <Criteria> emp = em.createQuery("Select e from Criteria e",
			Criteria.class).getResultList(); return emp;
			}
	public void removeCriterien(int id) {
		Query q = em.createNativeQuery("Delete from criteria where criteria.id = " + id);
		q.executeUpdate();
		System.out.println("Out of removeEmp : ");	

	}
public Criteria findCriteriaById(int id) {
		
		Criteria CR = em.find(Criteria.class, id);
		
		return CR;
	}




}
