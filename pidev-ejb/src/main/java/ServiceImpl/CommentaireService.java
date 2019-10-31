package ServiceImpl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entities.Commentaire;
import Entities.EvaluationSheet;
import ServiceRemote.CommentaireRemote;

@Stateless
@LocalBean
public class CommentaireService implements CommentaireRemote {

	@PersistenceContext
	EntityManager em;


	public int ajouterEvaluationSheet(Commentaire commentaire) {
		em.persist(commentaire);
		return commentaire.getId();
	}
	public void removeCommentaire(int id) {
		System.out.println("In removeEmp : ");
		em.remove(em.find(Commentaire.class, id));
		System.out.println("Out of removeEmp : ");	

	}
}