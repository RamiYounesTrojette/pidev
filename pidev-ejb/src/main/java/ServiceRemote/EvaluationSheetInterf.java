package ServiceRemote;

import java.util.List;

import javax.ejb.Remote;

import Entities.EvaluationSheet;


@Remote
public interface EvaluationSheetInterf {
	public Boolean ajouterEvaluationSheet(EvaluationSheet evaluationsheet);
	public void updateEval(EvaluationSheet evaluationsheet);
	public List<EvaluationSheet> getAllEval();
	
}