package resources;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.resource.spi.work.SecurityContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import Entities.Employee;
import Entities.EvaluationSheet;
import ServiceImpl.CriteriaService;
import ServiceImpl.EvaluationSheetService;

@Path("evaluation")
@RequestScoped
public class evaluationResources {
	public static List<EvaluationSheet> Listeevaluationsheet = new ArrayList<EvaluationSheet>();
 
@Context 
private UriInfo uriinfo;

	@EJB
	EvaluationSheetService Evaluationservice;
	@EJB
	CriteriaService criteriaservice;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEvaluationList() {
		System.out.println("kelma");
        List<EvaluationSheet> evals = new ArrayList<EvaluationSheet>();
		evals=Evaluationservice.getAllEval();
		
		return Response.ok(evals).build();



	}
	
	@GET
	@Path("employe")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployeeList() {
		System.out.println("kelma");
        List<Employee> evals = new ArrayList<Employee>();
		evals=Evaluationservice.getAllEmployes();
		
		return Response.ok(evals).build();



	}
	

	 
	
	
	
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchEvaluation(@PathParam(value ="id") int id) {
		List<EvaluationSheet> evals = new ArrayList<EvaluationSheet>();
		evals=Evaluationservice.getAllEval();
		for (EvaluationSheet e:evals) {

			if(e.getId()==id) {

				return Response.status(Status.OK).entity(e).build();
			}
		}

		return Response.status(Status.NOT_FOUND).entity("Votre Evaluation non trouve").build();

	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)

	public Response updateEvaluation(@PathParam (value = "id")int id , EvaluationSheet e) {
		List<EvaluationSheet> evals = new ArrayList<EvaluationSheet>();
		evals=Evaluationservice.getAllEval();
		for(int i = 0;i<evals.size();i++) {
			if(evals.get(i).getId()==id) {
				
				evals.get(i).setScore((e.getScore()));
				
				return Response.status(Status.ACCEPTED).entity("update succesful").build();

			}
		}

		return Response.status(Status.NOT_MODIFIED).entity("update failed").build();
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response addEvaluation(EvaluationSheet evaluation) {
		

		 Evaluationservice.ajouterEvaluationSheet(evaluation);
		
		
		
	
			return Response.status(Status.CREATED).entity(evaluation).build();
		

	}
	

	
	
	
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEpmploye(@PathParam("id") int id) {
		 
		Evaluationservice.removeEval(id);
			return Response.status(Status.OK).entity("Evaluation deleted").build();
			

	}
	
	
	
	
}
