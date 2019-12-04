package resources;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Criteria;
import Entities.EvaluationSheet;
import ServiceImpl.CriteriaService;
import ServiceImpl.EvaluationSheetService;

@Path("criteria")
@RequestScoped
public class CriteriaResources {
	public static List<Criteria> ListeCriteres = new ArrayList<Criteria>();
	@EJB
	CriteriaService criteriaservice;
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAssure(Criteria criteria) {


		 
		 criteriaservice.ajouterCriteria(criteria);
		 
		return Response.status(Status.CREATED).entity("Add successful").build();



	}
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)

	public Response updateCriteria(@PathParam (value = "id")int id , Criteria e) {
		List<Criteria> cr = new ArrayList<Criteria>();
		cr=criteriaservice.getAllCriterien();
		for(int i = 0;i<cr.size();i++) {
			if(cr.get(i).getId()==id) {
				
				cr.get(i).setDescription(e.getDescription());
				cr.get(i).setNote(e.getNote());
				
				return Response.status(Status.ACCEPTED).entity("update succesful").build();

			}
			
		}
		return Response.status(Status.NOT_MODIFIED).entity("update failed").build();
	}
	
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchEvaluation(@PathParam(value ="id") int id) {
		List<Criteria> CR = new ArrayList<Criteria>();
		CR=criteriaservice.getAllCriterien();
		for (Criteria e:CR) {

			if(e.getId()==id) {

				return Response.status(Status.OK).entity(e).build();
			}
		}

		return Response.status(Status.NOT_FOUND).entity("Votre Evaluation non trouve").build();

	}
		
	@DELETE
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteEpmploye(@PathParam("id") int id) {
		 
		criteriaservice.removeCriterien(id);
			return Response.status(Status.OK).entity("Criteria deleted").build();
			

	}
		
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayCriteriaList() {
	     List<Criteria> crit = new ArrayList<Criteria>();
	     crit=criteriaservice.getAllCriterien();
	     return Response.ok(crit).build();



	}
}
