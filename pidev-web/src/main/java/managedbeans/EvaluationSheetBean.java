package managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.EvaluationSheet;
import Entities.TypeEvaluationSheet;
import ServiceImpl.EvaluationSheetService;

@ManagedBean(name = "evaluationsheetBean") 
@SessionScoped 
public class EvaluationSheetBean implements Serializable {
	
		private static long serialVersionUID = 1L;

		public List<EvaluationSheet> getEvaluations() {
			return evaluations;
		}
		
	
		
		

		@EJB 
		EvaluationSheetService evaluationsheetservice;
		private TypeEvaluationSheet typeevaluation;
		private Date date;
		private Float score;
		
		
		
		public void addEvaluationSheet() { evaluationsheetservice.ajouterEvaluationSheet((new EvaluationSheet(typeevaluation,score))); 
		}
		
		
		
		public void RemoveEval(int evaluationId) { evaluationsheetservice.removeEval(evaluationId);}

		private Integer employeIdToBeUpdated;
		public void displayEval(EvaluationSheet eval)
		{
			this.setTypeevaluation(eval.getTypeevaluation());
			this.setScore(eval.getScore());
			
		}
		private List<EvaluationSheet> evaluations;
		public List<EvaluationSheet> getEval() { evaluations = evaluationsheetservice.getAllEval();
		return evaluations; 
		}
		
		public static long getSerialVersionUID() {
			return serialVersionUID;
		}



		public static void setSerialVersionUID(long serialVersionUID) {
			EvaluationSheetBean.serialVersionUID = serialVersionUID;
		}



		public EvaluationSheetService getEvaluationsheetservice() {
			return evaluationsheetservice;
		}



		public void setEvaluationsheetservice(EvaluationSheetService evaluationsheetservice) {
			this.evaluationsheetservice = evaluationsheetservice;
		}



		public TypeEvaluationSheet getTypeevaluation() {
			return typeevaluation;
		}



		public void setTypeevaluation(TypeEvaluationSheet typeevaluation) {
			this.typeevaluation = typeevaluation;
		}



		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}



		public Float getScore() {
			return score;
		}



		public void setScore(Float score) {
			this.score = score;
		}



		public Integer getEmployeIdToBeUpdated() {
			return employeIdToBeUpdated;
		}



		public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
			this.employeIdToBeUpdated = employeIdToBeUpdated;
		}



		public void setEvaluations(List<EvaluationSheet> evaluations) {
			this.evaluations = evaluations;
		}



		public void updateEval()
		{ evaluationsheetservice.updateEval(new EvaluationSheet(employeIdToBeUpdated,typeevaluation,score)); }
			
		
	}